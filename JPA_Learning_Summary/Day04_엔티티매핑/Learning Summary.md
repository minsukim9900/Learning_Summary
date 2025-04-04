# 4장 엔티티 매핑

- JPA를 사용하는데 가장 중요한 일은 엔티티와 테이블을 정확히 매핑
- 객체와 테이블 매핑 : @Entity, @Table
- 기본 키 매핑 : @Id
- 필드와 컬럼 매핑 : @Column
- 연관관계 매핑 : @ManyToOne, @JoinColumn

## @Entity

- JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 어노테이션을 필수로 붙여야 한다.
- @Entity가 붙은 클래스는 JPA가 관리하는 것으로, 엔티티라 부른다.
    
    ![img1.png](image/img1.png)
    
    - 기본 생성자는 필수다
    - final 클래스, enum, interface, inner 클래스에는 사용할 수 없다.
    - 저장할 필드에 final을 사용하면 안된다.

## @Table

- @Table은 엔티티와 매핑할 테이블을 지정한다.
- 생략하면 매핑한 엔티티 이름을 테이블 이름으로 사용한다.
    
    ![img2.png](image/img2.png)
    

## 다양한 매핑 사용

- JPA 시작 장에서 개발하던 회원 관리 프로그램에 다음 요구사항이 추가
    - 회원은 일반 회원과 관리자로 구분해야 한다.
    - 회원 가입일과 수정일이 있어야 한다.
    - 회원을 설명할 수 있는 필드가 있어야 한다. 이 필드는 길이 제한이 없다.
    
    ![img3.png](image/img3.png)
    
    ![img4.png](image/img4.png)
    
- 코드 분석
    - roleType : 자바의 enum을 사용해서 회원의 타입을 구분
        - 자바의 enum을 사용하려면 @Enumerated 어노테이션으로 매핑해야 한다.
    - createDate, lastModifiedDate : 자바의 날짜 타입은 @Temporal을 사용해서 매핑한다.
    - description : 회원을 설명하는 필드는 길이 제한이 없다.
        - 데이터베이스의 VARCHAR 타입 대신 CLOB 타입으로 저장해야 한다.
        - @Lob을 사용하면 CLOB, BLOB 타입을 매핑할 수 있다.

## 데이터베이스 스키마 자동 생성

- JPA는 데이터베이스 스키마를 자동으로 생성하는 기능을 지원한다.
- 클래스의 매핑정보를 보면 어떤 테이블에 어떤 컬럼을 사용하는지 알 수 있다.
- JPA는 이 매핑 정보와 데이터베이스 방언을 사용해서 데이터베이스 스키마를 생성한다.
- 스키마 자동 생성 기능은 persistence.xml에 속성을 추가하면 된다.
- 애플리케이션 실행 시점에 데이터베이스 테이블을 자동으로 생성한다.
    
    ```java
    <property name="hibernate.hbm2ddl.auto" value="create" />
    ```
    
- hibernate.show_sql 속성을 true로 설정하면 콘솔에 실행되는 테이블 생성 DDL을 출력한다.
    
    ```java
    <property name = "hibernate.show_sql" value = "true"/>
    ```
    
    ![img5.png](image/img5.png)
    
    ![img6.png](image/img6.png)
    
- 스키마 자동 생성 기능을 사용하면 애플리케이션 실행 시점에 데이터베이스 테이블이 자동으로 생성되므로 개발자가 테이블을 직접 생성하는 수고를 덜 수 있다.
- 하지만 스키마 자동 생성 기능이 만든 DDL은 운영 환경에서 사용할 만큼 완벽하지 않다.
- 개발 환경에서 사용하거나 매핑을 어떻게 해야 하는지 참고하는 정도로만 사용하는 것이 좋다.
    
    ![img7.png](image/img7.png)
    
- HBM2DDL 주의 사항
    - 운영 서버에서 create, create-drop, update처럼 DLL을 수정하는 옵션은 절대 사용하면 안된다.
    - 개발 서버나 개발 단계에서만 사용해야 한다.
    - 이 옵션들은 운영 중인 데이터베이스의 테이블이나 컬럼을 삭제할 수 있다.

## DDL 생성 기능

![img8.png](image/img8.png)

- 회원 이름은 필수로 입력되어야 하고, 10자를 초과하면 안된다는 제약 조건이 추가되었다.
- 스키마 자동 생성하기를 통해 만들어지는 DDL에 이 제약조건을 추가해보자.
    - @Column 매핑정보의 nullable 속성 값을 false로 지정하면 자동 생성되는 DDL에 not null 제약조건을 추가할 수 있다.
    - length 속성 값을 사용하면 자동 생성되는 DDL에 문자의 크기를 지정할 수 있다.
        
        ![img9.png](image/img9.png)
        
- 유니크 제약 조건을 만들어주는 @Table의 uniqueConstraints 속성을 알아보자
    
    ![img10.png](image/img10.png)
    
- 이런 기능들은 단지 DDL을 자동으로 생성할 때만 사용되고 JPA의 실행 로직에는 영향을 주지 않는다.
- 이 기능을 사용하면 애플리케이션 개발자가 엔티티만 보고도 손쉽게 다양한 제약조건을 파악할 수 있는 장점이 있다.
- JPA는 애플리케이션의 실행 동작에는 영향을 주지 않지만, 자동 생성되는 DDL을 위한 기능들도 있다.

## 기본 키 매핑

![img11.png](image/img11.png)

- 기본 키를 애플리케이션에서 직접 할당하는 대신에 데이터베이스가 생성해주는 값을 사용하려면 어떻게 매핑해야 할까?
- JPA가 제공하는 데이터베이스 기본 키 생성 전략
    - 직접 할당 : 기본 키를 애플리케이션에서 직접 할당
    - 자동 생성 : 대리 키 사용 방식
        - IDENTITY : 기본 키 생성을 데이터베이스에 우임
        - SEQUENCE : 데이터베이스 시퀀스를 사용해서 기본 키를 할당
        - TABLE : 키 생성 테이블을 사용
    - 자동 생성 전략이 이렇게 다양한 이유는 데이터베이스 벤더마다 지원하는 방식이 다르기 때문
    - SEQUENCE나 IDENTITY 전략은 사용하는 데이터베이스에 의존
    - TABLE 전략은 키 생성용 테이블을 하나 만들어두고 마치 시퀀스처럼 사용하는 방법
    - 기본 키를 직접 할당하려면 @Id만 사용
    - 자동 생성 전략을 사용하려면 @Id에 @GeneratedValue를 추가하고 원하는 키 생성 전략을 선택하면 된다.
        
        ![img12.png](image/img12.png)
        

### 기본 키 직접 할당 전략

![img13.png](image/img13.png)

- @Id 적용 가능 자바 타입
    - 자바 기본형
    - 자바 래퍼(wrapper) 형
    - String
    - java.util.Date
    - java.sql.Date
    - java.math.BigDecimal
    - java.math.BigInteger
- 기본 키 직접 할당 전략은 em.persist()로 엔티티를 저장하기 전에 애플리케이션에서 기본 키를 직접 할당하는 방법이다.
    
    ![img14.png](image/img14.png)
    
    ![img15.png](image/img15.png)
    

### IDENTITY 전략

- IDENTITY는 기본 키 생성을 데이터베이스에 위임하는 전략
- 주로 MySQL, PostgreSQL, SQL Server, DB2에서 사용
    
    ![img16.png](image/img16.png)
    
- 데이터베이스에 값을 저장할 때 ID 컬럼을 비워두면 데이터베이스가 순서대로 값을 채워준다.
- IDENTITY 전략은 AUTO_INCREMENT를 사용한 예제처럼 데이터베이스에 값을 저장하고 나서야 기본 키 값을 구할 수 있을 때 사용한다.
- 개발자가 엔티티에 직접 식별자를 할당하면 @Id 어노테이션만 있으면 되지만
- 식별자가 생성되는 경우에는 @GeneratedValue 어노테이션을 사용하고 식별자 생성 전략을 선택해야 한다.
    
    ![img17.png](image/img17.png)
    
    - em.persist()를 호출해서 엔티티를 저장한 직후에 할당된 식별자 값을 출력
    - 출력된 값 1은 저장 시점에 데이터베이스가 생성한 값을 JPA가 조회한 것
    
    ![img18.png](image/img18.png)
    
    - INSERT SQL이 데이터베이스에 전달한 후에 식별자 키를 구할 수 있으므로
    - 트랜잭션을 지원하는 쓰기 지연이 동작하지 않는다.

### SEQUENCE 전략

- 데이베이스 시퀀스는 유일한 값을 순서대로 생성하는 특별한 데이터베이스 오브젝트
- SEQUENCE 전략은 이 시퀀스를 사용해서 기본 키를 생성
    - 오라클, PostgreSQL, DB2, H2 데이터베이스 사용 가능
    
    ![img19.png](image/img19.png)
    
    ![img20.png](image/img20.png)
    
- 우선 사용할 데이터베이스 시퀀스를 매핑
- @SequenceGenerator를 사용해서 BOARD-SEQ_GENERATOR라는 시퀀스 생성기를 등록
- sequenceName 속성의 이름으로 BOARD_SEQ를 지정
- JPA는 이 시퀀스 생성기를 실제 데이터베이스의  BOARD_SEQ 시퀀스와 매핑
- 다음으로 키 생성 전략을 GenerationType.SEQUENCE로 설정
- generator = “BOARD_SEQ_GENERATOR”로 방금 등록한 시퀀스 생성기를 선택
- id 식별자 값은 BOARD_SEQ_GENERATOR 시퀀스 생성기가 할당
    
    ![img21.png](image/img21.png)
    
- 예제 4.13의 시퀀스 사용 코드는 IDENTITY 전략과 같지만 내부 동작 방식은 다르다.
    - SEQUENCE 전략은 em.persist()를 호출할 때 먼저 데이터베이스 시퀀스를 사용해서 식별자를 조회
    - 조회한 식별자를 엔티티에 할당한 후에 엔티티를 영속성 컨텍스트에 저장
    - 트랜잭션을 커밋해서 플러시가 일어나면 엔티티를 데이터베이스에 저장
    - IDENTITY 전략은 먼저 엔티티를 데이터베이스에 저장한 후 식별자를 조회해서 엔티티의 식별자에 할당

### @SequenceGenerator

![img22.png](image/img22.png)

- 매핑할 DDL은 다음과 같다.
    
    ```java
    create sequence [sequenceName]
    start with [initialValue] increment by [allocationSize]
    ```
    
- JPA 표준 명세에서는 sequenceName의 기본값을 JPA 구현체가 정의하도록 했다
- 위에서 설명한 기본값은 하이버네이트 기준
    
    ![img23.png](image/img23.png)
    
    ![img24.png](image/img24.png)
    
    ![img25.png](image/img25.png)
    

### TABLE 전략

- 키 생성 전용 테이블을 하나 만들고 여기에 이름과 값으로 사용할 컬럼을 만들어
데이터베이스 시퀀스를 흉내내는 전략
- 이 전략은 테이블을 사용하므로 모든 데이터베이스에 적용 가능
- TABLE 전략을 사용하려면 예제 4.14처럼 키 생성 용도로 사용할 테이블을 만들어야 한다.
    
    ![img26.png](image/img26.png)
    
- sequence_name 컬럼을 시퀀스 이름으로 사용하고
- next_val 컬럼을 시퀀스 값으로 사용한다.
- 컬럼의 이름은 변경할 수 있는데 여기서 사용한 것이 기본 값
    
    ![img27.png](image/img27.png)
    
- @TableGenerator를 사용해서 테이블 키 생성기를 등록
- 여기서 BOARD_SEQ_GENERATOR라는 이름의 테이블 키 생성기를 등록하고 방금 생성한 MY_SECUENCES 테이블을 키 생성요 테이블로 매핑
- TABLE 전략을 사용하기 위해 GenerationType.TABLE을 선택했다.
- @GerneratedValue.generator에 방금 만든 테이블 키 생성기를 지정했다.
- 이제부터 id 식별자 값은 BOARD_SEQ_GENERATOR 테이블 키 생성기가 할당
    
    ![img28.png](image/img28.png)
    
- TABLE 전략은 시퀀스 대신에 테이블을 사용한다는 것만 제외하면 SEQUENCE 전략과 내부 동작방식이 같다.
    
    ![img29.png](image/img29.png)
    
- @TableGenerator.pkColumnValue에서 지정한 “BOARD_SEQ”가 컬럼명으로 추가된 것을 확인할 수 있다.
- 이제 키 생성기를 사용할 때마다 next_val 컬럼 값이 증가한다.
- MY_SEQUENCES 테이블에 값이 없으면 JPA가 값을 INSERT 하면서 초기화하므로 값을 미리 넣어둘 필요 는 없다.

### @TableGenerator

- 표는 하이버네이트 기준

![img30.png](image/img30.png)
- JPA 표준 명세에서는 table.pkColumnName, valueColumnName의 기본값을 JPA 구현체가 정의함
    
    ![img31.png](image/img31.png)
    
    ![img32.png](image/img32.png)
    

### AUTO 전략

- 데이터베이스 종류도 많고 기본 키를 만드는 방법도 다양
- GermerationType.Auto는 선택한 데이터베이스 방언에 따라 IDENTITY, SEQUENCE, TABLE 전략 중 하나를 자동으로 선택
- 오라클을 선택하면 SEQUENCE, MySQL을 선택하면 IDENTITY
    
    ![img33.png](image/img33.png)
    
- @GerneratedValue.strategy의 기본 값은 AUTO
다음과 같이 사용해도 결과는 같다.
    
    ```java
    @Id @GeneratedValue
    private Long id;
    ```
    
- AUTO 전략의 장점은 데이터베이스를 변경해도 코드를 수정할 필요가 없다.
- 키 생성 전략이 아직 확정되지 않은 개발 초기 단계나 프로토타입 개발 시 편리하게 사용
- AUTO를 사용할 때 SEQUENCE나 TABLE 전략이 선택되면 시퀀스나 키 생성용 테이블을 미리 만들어 두어야 한다.
- 스키마 자동 생성 기능을 사용한다면 하이버네이트가 기본값을 사용해서 적절한 시퀀스나 키 생성용 테이블을 만들어 줄 것이다.

### 기본 키 매핑 정리

- 영속성 컨텍스트는 엔티티를 식별자 값으로 구분한다.
- 엔티티를 영속 상태로 만들려면 식별자 값이 반드시 있어야 한다.
- em.persist()를 호출한 직후 발생하는 일을 식별자 할당 전략별로 정리
    - 직접 할당 : em.persist()를 호출하기 전 애플리케이션에서 직접 식별자 값을 할당해야 한다.
        - 식별자 값이 없으면 예외가 발생
    - SEQUENCE : 데이터베이스 시퀀스에서 식별자 값을 획득한 후 영속성 컨텍스트에 저장
    - TALBE : 데이터베이스 시퀀스 생성용 테이블에서 식별자 값을 획득한 후 영속성 컨텍스트에 저장
    - IDENTITY : 데이터베이스에 엔티티를 저장해서 식별자 값을 획득한 후 영속성 컨텍스트에 저장

### 권장하는 식별자 선택 전략

- 데이터베이스 기본 키는 3가지 조건을 모두 만족해야 한다.
    - null 값은 허용하지 않음
    - 유일해야 한다.
    - 변해서 안 된다.
- 테이블의 기본 키를 선택하는 전략은 크게 2가지
    - 자연 키 (natural key)
        - 비즈니스에 의미가 있는 키
        - 주민등록번호, 이메일, 전화번호
    - 대리 키 (surrogate key)
        - 비즈니스와 관련 없는 임의로 만들어진 키, 대체 키로도 불린다.
        - 오라클 시퀀스, auto_increment, 키생성 테이블 사용

![img34.png](image/img34.png)

![img35.png](image/img35.png)

## 필드와 컬럼 매핑 : 레퍼런스

- 필드와 컬럼 매핑 분류
    
    ![img36.png](image/img36.png)
    

### @Column

- @Coluomn은 객체 필드를 테이블 컬럼에 매핑
    
    ![img37.png](image/img37.png)
    
    ![img38.png](image/img38.png)
    
    ![img39.png](image/img39.png)
    
    ![img40.png](image/img40.png)
    

@Column 생략

![img41.png](image/img41.png)

### @Enumerated

- 속성 정리
    
    ![img42.png](image/img42.png)
    
- 사용 예
    
    ![img43.png](image/img43.png)
    
    - EnumType.ORDINAL은 enum에 정의된 순서대로 ADMIN은 0, USER는 1 값이 데이터베이스에 저장
        - 장점 : 데이터베이스에 저장되는 데이터 크기가 작다.
        - 단점 : 이미 저장된 enum의 순서를 변경할 수 없다.
    - EnumTypeSTRING은 enum 이름 그대로 ADMIN은 “ADMIN”, USER는 “USER”라는 문자로 데이터베이스에 저장
        - 장점 : 저장된 enum의 순서가 바뀌거나 enum이 추가되어도 안전
        - 단점 : 데이터베이스에 저장되는 데이터 크기가 ORDINAL에 비해서 크다.
        
        ![img44.png](image/img44.png)
        

### @Temporal

- 날짜 타입 (java.util.Date, java.util.Calendar)을 매핑할 때 사용
- 속성 정리
    
    ![img45.png](image/img45.png)
    
- 사용 예
    
    ![img46.png](image/img46.png)
    
- 자바의 Date 타입에는 년월일 시분초가 있지만 데이터베이스 date(날짜), time(시간), timestamp(날짜와 시간)라는 세 가지 타입이 별도 존재
- @Temporal을 생략하면 자바의 Date와 가장 유사한 timestamp로 정의된다.
- timestamp 대신에 datetime을 예약어로 사용하는 데이터베이스도 있다.
- 데이터베이스 방언 덕분에 애플리케이션 코드는 변경하지 않아도 된다.
    - 방언에 따라 생성되는 DDL
        
        ![img47.png](image/img47.png)
        

### @Lob

- 데이터베이스 BLOB, CLOB 타입과 매핑
- 속성 정리
    - @Lob에는 지정할 수 있는 속성이 없다.
    - 매핑하는 필드 타입이 문자면 CLOB으로 매핑하고 나머지는 BLOB으로 매핑
        
        ![img48.png](image/img48.png)
        
- 사용 예
    
    ![img49.png](image/img49.png)
    
    ![img50.png](image/img50.png)
    

### @Transient

- 이 필드는 매핑하지 않는다. 따라서 데이터베이스에 저장하지 않고 조회하지도 않는다.
- 객체에 임시로 어떤 값을 보관하고 싶을 때 사용
    
    ![img51.png](image/img51.png)
    

### @Access

- JPA가 엔티티 데이터에 접근하는 방식을 지정
    - 필드 접근 : AccessType.FIELD로 지정
        - 필드에 직접 접근
        - 필드 접근 권이 private이어도 접근할 수 있다.
    - 프로퍼티 접근 : AccessType.PROPERTY로 지정
        - 접근자 Getter를 사용
    - Access를 설정하지 않으면 @Id의 위치를 기준으로 접근 방식이 설정
        
        ![img52.png](image/img52.png)
        
    - @Id가 필드에 있으므로 @Access(AccessType.FIELD)로 설정한 것과 같다.
    @Access는 생략해도 된다.
        
        ![img53.png](image/img53.png)
        
    - @Id가 프로퍼티에 있으므로 @Access (AccessType.PROPERTY)로 설정한 것과 같다.
    @Access는 생략해도 된다.
        
        ![img54.png](image/img54.png)
        
        ![img55.png](image/img55.png)
        
    - @Id가 필드에 있으므로 기본은 필드 접근 방식을 사용하고 getFullName()만 프로퍼티 접근 방식을 사용한다.
    - 회원 엔티티를 저장하면 회원 테이블의 FULLNMAE 컬럼에 firstName + lastName의 결과가 저장된다.

## 정리

- 스키마 자동 생성하기 기능은 엔티티 객체를 먼저 만들고 테이블은 자동으로 생성할 수 있다.
- JPA는 다양한 기본 키 매핑 전략을 지원한다.
    - 직접 할당
    - IDENTITY
    - SEQUENCE
    - TABLE
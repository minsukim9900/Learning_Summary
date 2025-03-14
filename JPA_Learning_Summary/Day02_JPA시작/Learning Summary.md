# 2장 JPA 시작

### 객체 매핑 시작

![스크린샷 2025-03-13 오후 5.46.16.png](attachment:afba0279-c077-46ca-bdeb-19760e01596f:스크린샷_2025-03-13_오후_5.46.16.png)

```java
@Entity
@Table(name = "MEMBER")
public class Member {
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "NAME")
	private String username;
	
	//매핑 정보가 없는 필드
	private Integer age;
}
```

- @Entity
    - 이 클래스를 테이블과 매핑한다고 JPA에게 알려준다.
    - @Entity가 사용된 클래스를 엔티티 클래스라 한다.
- @Table
    - 엔티티 클래스에 매핑할 테이블 정보를 알려준다.
    - 여기서는 name 속성을 사용해서 Member 엔티티를 Member 테이블에 매핑했다.
    - 어노테이션을 생략하면 클래스 이름을 테이블 이름으로 매핑한다.
    - (더 정확히는 엔티티 이름을 사용한다.)
- @Id
    - 엔티티 클래스의 필드를 테이블의 기본 키 (primary key)에 매핑한다.
    - @Id가 사용된 필드를 식별자 필드라 한다.
- @Column
    - 필드를 컬럼에 매핑한다.
    - 여기서는 name 속성을 사용해서  Member 엔티티의 username 필드를 Member  테이블의 NAME 컬럼에 매핑했다.
- 매핑 정보가 없는 필드
    - age 필드에는 매핑 어노테이션이 없다.
    - 매핑 어노테이션을 생략하면 필드명을 사용해서 컬럼명으로 매핑한다.
    - 만약 대소문자를 구분하는 데이터베이스를 사용하면 @Column (name = “AGE”) 처럼 명시적으로 매핑해야 한다.

### persistence.xml 설정

- JPA는 persistence.xml을 사용해서 필요한 설정 정보를 관리
- JPA 설정은 영속성 유닛(persistence-unit)이라는 것부터 시작하는데 일반적으로 연결할 데이터베이스당 하나의 영속성 유닛을 등록한다.
- 영속성 유닛에는 고유한 이름을 부여해야 한다.
- JPA 표준 속성
    - javax.persistence.jdbc.driver : JDBC 드라이버
    - javax.persistence.jdbc.user : 데이터베이스 접속 아이디
    - javax.persistence.jdbc.password : 데이터베이스 접속 비밀번호
    - javax.persistence.jdbc.url : 데이터베이스 접속 URL
- 하이버네이트 속성
    - hibernate.dialect : 데이터베이스 방언(Dialect) 설정

### 데이터베이스 방언

![스크린샷 2025-03-13 오후 10.03.03.png](attachment:79c89817-1470-440c-8c77-993626923e7c:스크린샷_2025-03-13_오후_10.03.03.png)

- JPA는 특정 데이터베이스에 종속적이지 않은 기술
- 데이터베이스마다 다음과 같은 차이점이 있다.
    - 데이터 타입
    - 다른 함수명
    - 페이징 처리
- SQL 표준을 지키지 않거나 특정 DB만의 고유한 기능을 방언(Dialect)이라 한다
- 하이버네이트를 포함한 대부분의 JPA 구현체들은 다양한 데이터베이스 방언 클래스를 제공한다.
- 개발자는 JPA가 제공하는 표준 문법에 맞추어 JPA를 사용하면 되고,
- 특정 DB에 의존적인 SQL은 데이터베이스 방언이 처리해준다.
- 데이터베이스가 변경되어도 방언만 교체하면 된다.
- 데이터베이스 방언을 설정하는 방법은 JPA에 표준화되어 있지 않다.

### 애플리케이션 개발

코드는 크게 3부분으로 나뉘어 있다.

- 엔티티 매니저 설정
- 트랜잭션 관리
- 비즈니스 로직

### 엔티티 매니저 설정

![스크린샷 2025-03-14 오후 4.17.18.png](attachment:635cbeb9-2765-482a-9f97-be980b342819:스크린샷_2025-03-14_오후_4.17.18.png)

- **엔티티 매니저 팩토리 생성**
    - 우선 persistence.xml의 설정 정보를 사용해서 엔티티 매니저 팩토리를 생성해야 한다.
    - Persistence 클래스
        - 엔티티 매니저 팩토리를 생성해서 JPA를 사용할 수 있게 준비한다.
        
        ```java
        EntityMangerFactory emf = Persistence.createEntityMangerFactory("jpabook");
        ```
        
    - META-INF/persistence.xml에서 이름이 jpabook인 영속성 유닛(persistence-unit)을 찾아서 엔티티 매니저 팩토리를 생성한다.
    - persistence.xml의 설정 정보를 읽어서 JPA를 동작시키기 위한 기반 객체를 만들고 JPA 구현체에 따라서는 데이터베이스 커넥션 풀도 생성하므로 엔티티 매니저 팩토리를 생성하는 비용은 아주 크다.
    - 엔티티 매니저 팩토리는 애플리케이션 전체에서 딱 한 번만 생성하고 공유해서 사용해야 한다.
- **엔티티 매니저 생성**
    
    ```java
    EntityManger em = emf.createEntityManger();
    ```
    
    - 엔티티 매니저 팩토리에서 엔티티 매니저를 생성한다.
    - JPA의 기능 대부분은 이 엔티티 매니저가 제공한다.
    - 엔티티 매니저를 사용해서 엔티티를 데이터베이스에 CRUD할 수 있다.
    - 엔티티 매니저는 내부에 데이터소스(데이터베이스 커넥션)를 유지하면서 데이터베이스와 통신
    - 애플리케이션 개발자는 엔티티 매니저를 가상의 데이터베이스로 생각
    - 엔티티 매니저는 데이터베이스 커넥션과 밀접한 관계가 있으므로 스레드간에 공유하거나 재사용하면 안된다.
- 종료
    - 사용이 끝난 엔티티 매니저는 다음처럼 반드시 종료한다.
    
    ```java
    em.close(); // 엔티티 매니저 종료
    ```
    
    - 애플리케이션을 종료할 때 엔티티 매니저 팩토리도 종료한다.
    
    ```java
    emf.close(); // 엔티티 매니저 팩토리 종료
    ```
    

### 트랜잭션 관리

- JPA를 사용하면 항상 트랜잭션 안에서 데이터를 변경해야 한다.
- 트랜잭션 없이 데이터를 변경하면 예외 발생
- 트랜잭션을 시작하면 앤티티 매니저(em)에서 트랜잭션 API를 받아와야 한다.
    
    ```java
    EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
    
            try {
                
                tx.begin(); //트랜잭션 시작
                logic(em);  //비즈니스 로직
                tx.commit();//트랜잭션 커밋
    
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback(); //트랜잭션 롤백
            } finally {
                em.close(); //엔티티 매니저 종료
            }
    ```
    
- 트랜잭션 API를 사용해서 비즈니스 로직이 정상 동작하면 트랜잭션을 커밋 commit하고
예외가 발생하면 트랜잭션을 롤백한다.

### 비즈니스 로직

- 회원 엔티티를 하나 생성한 다음 엔티티 매니저를 통해 데이터베이스에 CRUD 한다.
- 엔티티 매니저는 객체를 저장하는 가상의 데이터베이스처럼 보인다.
    
    ```java
    public static void logic(EntityManager em) {
    
            String id = "id1";
            Member member = new Member();
            member.setId(id);
            member.setUsername("지한");
            member.setAge(2);
    
            //등록
            em.persist(member);
    
            //수정
            member.setAge(20);
    
            //한 건 조회
            Member findMember = em.find(Member.class, id);
            System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());
    
            //목록 조회
            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
            System.out.println("members.size=" + members.size());
    
            //삭제
            em.remove(member);
    
        }
    ```
    
    - 등록
        - 엔티티를 저장하려면 엔티티 매니저의 persist() 메소드에 저장할 엔티티를 넘겨주면 된다.
        - JPA는 회원 엔티티의 매핑 정보(어노테이션)를 분석해서 INSERT SQL을 만들어 데이터베이스에 전달한다.
    - 수정
        - JPA는 어떤 엔티티가 변경되었는지 추적하는 기능을 갖추고 있다.
        - member.setAge(20)처럼 엔티티의 값만 변경하면
        - UPDATE MEMBER SET AGE = 20, NAME = ‘지한’ WHERE ID = ‘id1’
        - UPDATE SQL을 생성해서 데이터베이스에 값을 변경
    - 삭제
        - remove() 메소드에 삭제하려는 엔티티를 넘겨준다.
        - JPA는 다음 DELETE SQL을 생성해서 실행한다.
    - 한 건 조회
        - find() 메소드는 조회할 엔티티 타입과 @Id로 데이터베이스 테이블의 
        기본 키와 매핑한 식별자 값으로 엔티티 하나를 조회하는 가장 단순한 조회메소드
        - SELECT SQL을 생성해서 데이터베이스에 결과를 조회
        - 조회한 결과 값으로 엔티티를 생성해서 반환

### JPQL

```java
TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
List<Member> members = query.getResultList();
```

- JPA를 사용하면 애플리케이션 개발자는 엔티티 객체를 중심으로 개발 데이터베이스에 대한 처리는 JPA에 맡겨야 한다.
- JPA는 엔티티 객체를 중심으로 개발하므로 검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색
- 테이블이 아닌 엔티티 객체를 대상으로 검색하려면 데이터베이스의 모든 데이터를 애플리케이션으로 불러와서 엔티티 객체로 변경한 다음 검색해야 한다. ⇒ 이는 불가능
- JPA는 JPQL(Java Persistence Query Language)이라는 쿼리 언어로 이런 문제를 해결
    - JPQL은 엔티티 객체를 대상으로 쿼리, 클래스와 필드를 대상으로 쿼리
    - SQL은 데이터베이스 테이블을 대상으로 쿼리
- select m from Member m이 바로 JPQL
- 여기서 from Member는 회원 엔티티 객체를 말하는 것
- Member 테이블이 아님
- JPQL은 데이터베이스 테이블을 전혀 알지 못한다.

### JPQL 사용법

- em.createQuery(JPQL 반환타입) 메소드를 실행해서 쿼리 객체 생성
- 쿼리 객체의 getResultList() 메소드를 호출하면 된다.
- JPA는 JPQL을 분석해서 적절한 SQL을 만들어 데이터베이스에서 데이터를 조회한다.
- JPQL은 대소문자를 명확하게 구분하지만, SQL은 관례상 대소문자를 구분하지 않고 사용
# Java - 다형성, 추상클래스

## 다형성(Polymorphism)

### 다형성

- 실제 하나의 객체를 다양한 타입의 참조로 사용하는 것
- 다양한 유형의 여러 객체를 하나의 공통된 타입으로 참조할 수 있는 것
- **상속 관계에 있을 때 조상클래스 타입으로 자손 클래스의 객체를 참조할 수 있다.**
- **다양한 타입으로 참조하더라도 참조만 바뀔 뿐 실제 객체 자체(객체의 행위)는 변함이 없다.**
- 하나의 이름으로 다양한 기능을 구현할 수 있다.
- 다형성의 종류
    - 임시 다형성(Ad hoc polymorphism) : 메서드 오벌로딩, 연산자 오버로딩 (자바에서는 연산자 오버로딩 지원 X)
        - 메서드 오버로딩 : 매개변수는 다르면서 이름이 같은 메서드 여러개 정의
        - 연산자 오버로딩 ⇒ 여러가지 기능을 갖도록 연산자 자체를 재정의
    - 매개변수 다형성(Parametric polymorphism) : 제너릭
    - 서브타입 다형성(Subtyping) : 상속 관계에 있을 때 조상 클래스의 타입으로 자손 객체 참조 가능
- 다형성의 장점
    - 코드 재사용성 증가, 유연성과 확장성 증가, 가독성 개선

### 다형성의 모습


- 다형성이란? 多 形을 가질 수 있는 성질
- 상속 관계에 있을 때 조상 클래스의 타입으로 자식 클래스 객체를 참조할 수 있다.


- 메모리 상의 모습
    
    = new Student();

    
- 참조변수의 형 변환
    
    
    - 자손 타입 → 조상 타입 (묵시적 형 변환)
    - 형 변환 생략 가능
        
        ```java
        Student st = new Student();
        Person p = st;
        ```
        
    
    - 조상 타입 → 자손 타입 (명시적 형 변환)
    - 형 변환 생략 불가능
        
        ```java
        Person p = new Person();
        Student st = (Student) p;
        ---------------------------
        Person p = new Student();
        Student st = (Student) p;
        ```
        
- 참조변수의 형 변환

```java
Person p = new Person();
Student st = (Student) p;
```


- instanceof 연산자
    
    
    - 참조변수가 참조하고 있는 인스턴스의 타입을 확인 하기 위해서 사용
    - 결과를 boolean 으로 반환
    - true가 반환이 되면 해당 타입으로 형 변환 가능
    
    ```java
    Person person = new Person();
    
    if(person instanceof Student) {
    	Student student = (Student)person;
    	student.study();
    }
    ```
    
- 참조 변수와 인스턴스 멤버의 관계
    
    
- 참조 변수와 인스턴스 멤버의 관계
    - 상속 관계에서 멤버 변수가 중복이 되면 참조 변수 타입에 따라 연결이 달라짐
    - 메서드가 중복될 때 무조건 자식 클래스의 메서드가 호출 됨.
    - static 메서드는 참조 변수 타입의 영향을 받기 때문에 이를 방지하고자 클래스 이름으로 메서드 호출
- 다형성의 활용 - 다른 타입의 객체를 다루는 배열
    
    
- 다형성의 활용 - 매개변수의 다형성
    - 사람의 정보를 출력하려면…
    
    ```java
    public String info(Teacher t) { /*내용 생략*/ }
    public String info(Student st) { /*내용 생략*/ }
    ...
    
    public String info(Person p) { /*내용 생략*/ }
    public void println(Object x) {
    	String s = String.valueOf(x);
    	synchronized (this) {
    		print(s);
    		newLine();
    	}
    }
    ```
    

## 추상클래스(abstract class)

- 추상 클래스 정의
    
    - 한식요리사, 일식요리사 모두 cook 메서드를 가지고 있음
    - 조상 클래스 Chef에 선언하고 각 자손 클래스에서 override 예정
    - 사용되지 않는 Chef 클래스에 cook() 메서드가 필요한가??
    
    - cook() 메서드는 자손 클래스에서 반드시 재정의해서 사용되기 때문에 조상의 구현이 무의미
    - 메서드의 선언부만 남기고 구현부는 ;(세미콜론)으로 대체
    - 구현부가 없으므로 abstract 키워드를 메서드 선언부에 추가
    - 객체를 생성할 수 없는 클래스라는 의미로 클래스 선언부에 abstract를 추가
        
        
- 추상 클래스 특징
    - abstract 클래스는 상속 전용의 클래스
    - 클래스에 구현부가 없는 메서드가 있으므로 객체를 생성할 수 없음
    - 상위 클래스 타입으로 자식을 참조할 수는 있음
        
    - 조상 클래스에서 상속 받은 abstract 메서드를 재정의 하지 않은 경우
    클래스 내부에 abstract 메서드가 있으므로 자식 클래스는 abstract 클래스가 되어야함.
- 추상 클래스 사용하는 이유
    - abstract 클래스는 구현의 강제를 통해 프로그램의 안정성 향상
# Java - 상속

### UML 클래스 다이어그램

- 통합 모델링 언어
- 많은 종류의 다이어그램이 정의되어 있고, 클래스 다이어그램은 그 중 하나

### 클래스

- 사각형 모양으로 나타냄
- Level of Detail 에 따라 다양한 모습으로 나타낼 수 있음
- visibility는 다음 중하나
    - (+) public visibility
    - (#) protected visibility
    - (-) private visibility
    - (~) package visibility

### 인터페이스, 추상 클래스

- 이름 앞에 인터페이스는  <<interface>>를 추가
- 추상클래스는 <<abstract>>를 추가하거나
중괄호 표기법으로 abstract 임을 뒤 또는 아래에 표시하거나 이텔릭체 표현

### 관계 : 클래스, 인터페이스 간의 관계를 나타냄


## 상속(Inheritance)

어떤 클래스의 특성을 그대로 갖는 새로운 클래스르 정의한 것

### 상속의 특징

1. 확장성, 재 사용성
    - 부모의 생성자와 초기화 블록은 상속 X
2. 클래스 선언 시 extends 키워드를 명시
    - 자바는 다중 상속 허용 X,  단일 상속 지원
3. 관계
    - 부모 (상위, Super) 클래스 : Person
    - 자식 (하위, Sub) 클래스 : Student
4. 자식 클래스는 부모 클래스의 멤버변수, 메소드를 자신의 것처럼 사용할 수 있다. (단, 접근 제한자에 따라 사용 여부가 달라진다.)
5. Object 클래스는 모든 클래스의 조상 클래스
    - 별도의 extends 선언이 없는 클래스는 extends Object가 생략
6. super 키워드
    - super를 통해 조상 클래스의 생성자 호출
    - super() : 부모클래스 생성자 호출
    - 생성자 내부에서 super()쓰지 않았다면?
        
        → super(); 생략
        
    

    
7. 오버라이딩 (재정의, Overriding)
    

    
    - **상위 클래스에 선언된 메서드를 자식 클래스에서 재정의 하는 것**
    - 메서드의 이름, 반환형, 매개변수 (타입, 개수, 순서) 동일 해야 한다.
    - 하위 클래스의 접근제어자 범위가 상위 클래스보다 크거나 같아야 한다.
        
        ⇒ 부모클래스의 내용(메서드)을 자식이 감출 수 없다. 
        
    - 조상보다 더 큰 예외를 던질 수 없다.
    - 메서드 오버로딩(overloading)과 혼동하지 말 것!!

## Object

### Object 클래스

- 가장 최상위 클래스로 모든 클래스의 조상
- Object의 멤버는 모든 클래스의 멤버
    
    

### toString 메서드

- 객체를 문자열로 변경하는 메서드

```java
public String toString() {
	return getClass().getName() + "0" + Integer.toHexString(hashCode());
}
```

- 정작 궁금한 내용은 주소 값이 아닌 내용이 궁금

```java
@Override
public String toString() {
	return "Student [name = " + name + ", age= " + age + ", major = " + major+"]";
}
```

### equals 메서드

- 두 객체가 같은지를 비교하는 메서드

```java
public boolean equals(Object obj) {
	return (this == obj);
}
```

- 두 개의 래퍼런스 변수가 같은 객체를 가리키고 있는가?

```java
Object obj1 = new Object();
Object obj2 = new Object();
Object obj3 = obj2

// obj1 != obj2
// obj2 == obj3
```

- 우리가 비교할 것은 정말 객체의 주소 값인가?
    - 두 객체의 내용을 비교할 수 있도록 equals 메서드 재정의
    - 객체의 주소 비교: == 활용
    - 객체의 내용 비교 : equals 재정의

### hashCode

- 객체의 해시 코드 : 시스템에서 객체를 구별하기 위해 사용되는 정수 값
- HashSet, HashMap 등에서 객체의 동일성을 확인하기 위해 사용
    
    
- equals 메서드를 재정의 할 때는 반드시 hashCode도 재정의 할 것
- 미리 작성된 String이나 Number 등에서 재정의 된 hashCode 활용 권장

## final

### final

- 해당 선언이 최조애 상태, 결코 수정 될 수 없음
- final 클래스 : 상속 금지
- final 메소드 : overriding 금지
- final 변수 : 더 이상 값을 바꿀 수 없음 상수화
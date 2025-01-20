package test05_overriding;

public class Student extends Person{
	String major;
	
	//아무런 생성자도 정의하지 않은 상태
	// => 컴파일러가 기본 생성자 Student(){}를 만들어 줌
	// => 생성자는 내부에 기본적으로 super(); 가 생략
	// => 기본적으로 부모클래스의 기본 생성자를 호출한다는 뜻!!
	
	// 빈 공간에 ctrl + spacebar
//	public Student() {
//		//super(); // 생성자 내부에는 기본적으로 super(); 가 생략
//		//내부적으로 Person()을 호출하고 있다.
//		//프로그래머가 명시적으로 super()을 호출하지 않아도
//		//기본적으로 super();를 호출
//		//프로그래머가 명시적으로 super()를 호출하면??
//		//=> super()를 넣어주지 않는다.
//		// TODO Auto-generated constructor stub
//	}
	
	// 마우스 우클릭 > Source > Generate Constructor...
	public Student() {
		super();
	}
	
	public Student(String name, int age, String major) {
		// super(); // super()는 하나만 쓸 수 있다.
		super(name, age); // 부모의 생성자를 이요해서 초기화한다.
		this.major = major;
	}
	// 부모의 eat()이라는 메서드가 있지만..
	// 그대로 쓰고 싶지 않고 조금 바꾸고 싶다.
	// 자식 클래스에서 매서드를 재정의할 수있다.
	void eat() {
		System.out.println("지식을 먹는다.");
	}
	
	void study() {
		super.eat();
		System.out.println("공부를 합니다.");
	}

}

package test07_abstract;


// 추상 메서드를 하나라도 가지고 있다면
// 해당 클래스로는 객체 생성이 불가 => 추상 클래스로 만들어줘야 한다./
// 앞에 abstract 키워드를 붙여줘야 한다.
abstract class Animal {
	private String name;
	private int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 쓰이지 않은 메서드를 아예 없앨 것이 아니라
	// 추상 메서드로 만들 수 있다.
	// 추상 메서드: 본문이 없는 메서드
	// - abstract 키워드 명시
	
	public abstract void speak();
	// 만약 쓰이지 않는다고 해서 삭제를 하게 되면
	// 1. 자식에서 오버라이드 불가
	// 2. 참조형 변수에서 참조 불가..
	//    (해당 참조에 클래스에 정의되어 있는 것만 보이므로)
	
	public void eat() {
		System.out.println(name + "가 밥을 먹고 있습니다.");
	}
	
	//Getter와 Setter 메서드
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}

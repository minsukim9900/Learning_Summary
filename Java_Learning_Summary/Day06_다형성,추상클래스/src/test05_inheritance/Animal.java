package test05_inheritance;

public class Animal {
	private String name;
	private int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void speak() {
		System.out.println("동물이 소리를 냅니다.");
		// 쓰이지 않은 코드
	}
	
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

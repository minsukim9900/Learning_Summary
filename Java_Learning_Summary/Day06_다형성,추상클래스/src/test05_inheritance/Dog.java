package test05_inheritance;

public class Dog extends Animal {
	public Dog(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void speak() {
		System.out.println("강아지가 말합니다. : 멍멍");
	}
}

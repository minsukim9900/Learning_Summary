package test06_delete_method;

public class Cow extends Animal {
	public Cow(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void speak() {
		System.out.println("소가 말합니다. : 음모");
	}
}

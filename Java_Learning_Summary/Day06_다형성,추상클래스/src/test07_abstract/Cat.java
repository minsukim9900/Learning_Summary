package test07_abstract;

public class Cat extends Animal {
	public Cat(String name, int age) {
		super(name, age);
	}
	
	
	// 각각의 자식 클래스에서
	// eat()은 그대로 물려받아 사용하고 있는 반면...
	// speak()는 자식에서 재정의해서 사용하고 있음..
	
	
	@Override
	public void speak() {
		System.out.println("고양이가 말합니다. : 야옹");
	}
}

package jvm_static;

public class PersonTest {
	public static void main(String[] args) {
		System.out.println(Person.pCount);
		
		Person p = new Person();
		p.pCount = 200;
		System.out.println(p.pCount);
		// 인스턴스를 통해서도 접근은 되지만, 클래스이름으로 접근하는 것을 권장.
		System.out.println(Person.pCount);
	}
}

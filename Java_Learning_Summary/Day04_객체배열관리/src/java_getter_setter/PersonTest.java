package java_getter_setter;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		
		p.setAge(30);
		System.out.println(p.getAge());
		
		p.setAge(-10);
		System.out.println(p.getAge());
	}
}

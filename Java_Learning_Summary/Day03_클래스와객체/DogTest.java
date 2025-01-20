
public class DogTest {
	public static void main(String[] args) {
		Dog d = new Dog("메리", 4);
		System.out.println(d.name);
		System.out.println(d.age);
		
		Dog a = new Dog(); //컴파일러가 기본 생성자는 이제 추가하지 않는다.
	}
}

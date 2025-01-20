package test07_generic_method;

// 제네릭 클래스
// < > 안에 타입 파라미터를 정해준다.
class Box<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	//제네릭 메서드
	public <U> void printClassName(U item) {
		System.out.println("Item type:" + item.getClass().getName());;
	}

}

public class BoxTest {
	public static void main(String[] args) {
		// 제네릭 클래스의 사용 : 사용 시점에 타입 매개변수에 타입을 정해준다.
		Box<Integer> intBox = new Box<Integer>();

		intBox.printClassName("Hi");
		intBox.printClassName(42.42);
		
	}
}

package test03_throws;

public class ThrowsTest1 {
	
	//CheckedException과 throws
	// - CheckedException : 컴파일러가 예외 처리를 강제 (예외처리 하지 않으면 컴파일 진행x)
	// - 선택 2가지 : 1. try~catch로 예외처리를 직접하든지
	//			    2. throws로 전달.
	// - throws 의미?
	// - 1. (메서드를 정의하는 프로그래머) => 미안하지만.. 이 메서드에서 처리하지 않을게..
	//		이 메서드를 사용하는 사람이 예외를 처리해서 쓰도록..(컴파일러가 예외 처리 강제)
	// - 2. (이 메서드를 사용하는 프로그래머) 이 메서드는 CheckedException을 발생시킬 수 있는 메서드 구나?
	// 		내가 이 메서드를 쓰려면, 내가 예외 처리해야겠네.
	// - 3. (컴파일러) CheckedException은 원래 무조건 처리해야되는데.. 메서드 선언엣다가 throws를 해놨으니
	//		한 번만 봐줄게 (이 메서드 본문 안에서만 봐줄게), 그런데 이 메서드 호출하는 쪽에서는 얄짤없어..
	// 프로그램 시작점인 main 메서드조차 throws 한다면? => 결국에는 예외는 처리되지 않은체 남게 된다.
	// 예외는 처리되지 않은 것이다.
	// 비정상적 종료가 된다.
	
	public static void main(String[] args) {
		
		
		try {
			method1();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	private static void method1() throws ClassNotFoundException {
		method2();
	}

	private static void method2() throws ClassNotFoundException {
		Class.forName("Hello"); // CheckedException 발생!
	}
	
	
}

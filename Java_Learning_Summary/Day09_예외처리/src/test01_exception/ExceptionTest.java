package test01_exception;

public class ExceptionTest {
	public static void main(String[] args) {
		
		
		
		// 1. Unchecked Exception
		// - RunTimeException의 자손
		// - 저장하는 순간 => 이클립스에서 컴파일 수행
		// - 컴파일 시점에서 확인하지 않았다.
		// - 컴파일 자체는 완료가 되었다.
		// - 일단 실행은 되었음
		int[] nums = {10};
		System.out.println(nums[2]);
		
		
		// 2. Checked Exception
		// - Exception의 자손 중에서, RunTimeException의 자손은 아닌 애들
		// - 빨간 줄
		// - 저장은 했는데 빨간 줄 => 컴파일 자체가 수행되지 않았다.
		//Class.forName("Hello");
		//메모리에 로드하라.
		//Thread.sleep(1000); //일시정지.
		// -예외 처리 방법은?
		
		
	}
}

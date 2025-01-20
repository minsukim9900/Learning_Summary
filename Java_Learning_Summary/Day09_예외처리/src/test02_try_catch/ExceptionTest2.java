package test02_try_catch;

public class ExceptionTest2 {
	public static void main(String[] args) {
		
		
		int[] nums = {10};
		
		// try... catch
		
		// 1. 예외가 발생했고 성공적으로 처리되었을 때(catch 문을 만났을 때)
		// : 1 -> (2) -> 4 -> 5
		// 2. 예외가 발생했는데 성공적으로 처리되지 못했을 때 (catch 문을 못만났을 때)
		// 1 -> (2- 비정상종료)
		// 3. 예외가 발생하지 않았을 때 : 1 -> 2 -> 3 -> 5
		
		try {
			System.out.println("정상 코드 1"); //(1) 정상 코드
			System.out.println(nums[0]); // (2) 예외 발생 가능한 코드
			int i = 1 / 0; 
			System.out.println("정상 코드 2"); //(3) 정상 코드
		} catch (ArithmeticException e) {
			System.out.println("잘못된 계산식입니다..");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스 범위를 벗어났어요.");
		}
		System.out.println("프로그램 종료");
	}
}

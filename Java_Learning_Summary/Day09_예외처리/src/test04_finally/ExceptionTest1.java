package test04_finally;

public class ExceptionTest1 {
	public static void main(String[] args) {
		
		//try ... catch ... finally
		// 정상적으로 실행되는 경우 1 2 4 5
		// 예외 발생 처리가 되는 경우 : 1 3 4 5
		// 예외 발생 처리가 안된 경우 : 1 4 5
		// 정상 실행 try문에 return이 있는 경우
		// 예외 발생, 처리 & catch문에 return이 있는 경우
		
		int[] nums = {10};
		
		
		try {
			System.out.println(1); 
			nums[3] = 40;
			System.out.println(2); 
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(3); 
			return;
		} finally {
			System.out.println(4);
		}
		System.out.println(5);
	}
}

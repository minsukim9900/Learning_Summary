package test02_recursive;

public class Stack_Factorial {

	public static void main(String[] args) {
		System.out.println(factorial1(10));
		System.out.println(factorial2(5));
	}

	static int factorial1(int N) {

		int result = 1;
		for (int i = 1; i <= N; i++) {
			result *= i;
		}
		return result;
	}
	
	static int factorial2(int N) {
		if(N == 0) {
			return 1;
		}else {
			return N * factorial2(N-1);
		}
		
	}
}

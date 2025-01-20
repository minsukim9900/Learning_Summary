package test01_power_recursive;

public class Power_Dived_Conqure {

	public static void main(String[] args) {

		int C = 2;
		int N = 10;
		System.out.println(pow(C, N));
		System.out.println(pow2(C, N));
	}

	private static int pow(int C, int N) {
		// 기저조건
		if (N == 1) {
			return C;
		}else if(N == 0) {
			return 1;
		}
		// 재귀 부분 :
		if (N % 2 == 0) {
			
			return pow(C, N / 2) * pow(C, N / 2);
			
		} else {
			return C * pow(C, (N - 1) / 2) * pow(C, (N - 1) / 2);
		}
	}
	
	private static int pow2(int C, int N) {
		// 기저조건
		if (N == 1) {
			return C;
		}else if(N == 0) {
			return 1;
		}
		// 재귀 부분 :
		if (N % 2 == 0) {
			int tmp = pow2(C, N/2);
			return tmp * tmp;
			
		} else {
			int tmp = pow2(C, (N-1)/2);
			return C * tmp * tmp;
		}
	}
	
}

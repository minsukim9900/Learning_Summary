package test01_power_recursive;

public class Power_for {

	public static void main(String[] args) {

		int C = 2;
		int N = 10;

		System.out.println(pow(C,N));
		System.out.println(pow2(C,N));

	}

	public static int pow(int C, int N) {
		int result = 1;

		for (int i = 1; i <= N; i++) {
			result *= C;
		}

		return result;
	}

	public static int pow2(int C, int N) {
		if (N == 0) {
			return 1;
		}

		return C * pow2(C, N - 1);
	}

}

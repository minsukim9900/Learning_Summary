package test02_recursive;

public class Stack_Fibonacci {
	public static void main(String[] args) {
		// System.out.println(fibo1(45));
		System.out.println(fibo2(243));
		//System.out.println(mFibo(200));
	}

	public static long fibo1(long n) {
		if (n <= 1) {
			return n;
		} else {
			return fibo1(n - 1) + fibo1(n - 2);
		}
	}

	public static long fibo2(long N) {
		long[] arr = new long[(int) (N + 1)];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[(int) N];
	}

	static long[] dp = new long[500];

	public static long mFibo(int N) {
		if (N <= 1)
			return N;
		if (dp[N] > 0)
			return dp[N];
		return dp[N] = mFibo(N - 1) + mFibo(N - 2);
	}
}

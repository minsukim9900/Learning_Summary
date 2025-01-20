package test01_fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Fibonacci_DP {

	static int[] callFibo = new int[1000];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		System.out.println(fibo(N));

	}

	private static long fibo(int N) {
		long[] dp = new long[N + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		return dp[N];

	}

}

package test01_fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Fibonacci_Memoization {

	static int[] callFibo = new int[1000];
	static long[] memo; // 계산 값을 저장하기 위한 공간을 할당

	static {
		memo = new long[1000];
		memo[0] = 0;
		memo[1] = 1;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		System.out.println(fibo(N));
		System.out.println(Arrays.toString(callFibo));

	}
	

	private static long fibo(int N) {
		
		
		if(N >= 2 && memo[N] == 0) {
			memo[N] = fibo(N-1) + fibo(N-2);
		}
		callFibo[N]++;
		
		return memo[N];
		
	}

}

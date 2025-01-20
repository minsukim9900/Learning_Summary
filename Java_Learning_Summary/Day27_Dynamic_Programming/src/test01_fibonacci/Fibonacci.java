package test01_fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Fibonacci {
	
	static int[] callFibo = new int[1000];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(N));
		System.out.println(Arrays.toString(callFibo));

	}

	private static int fibo(int N) {
		callFibo[N]++;
		if (N < 2)
			return N;

		return fibo(N - 1) + fibo(N - 2);

	}

}

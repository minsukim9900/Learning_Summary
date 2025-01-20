package test02_coin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change_Coin {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = Integer.parseInt(br.readLine());

		int[] dp = new int[money + 1];

		// 1, 4, 6원을 고민하려고 한다.

		for (int i = 1; i <= money; i++) {
			int minCnt = 987654321;

			minCnt = Math.min(minCnt, dp[i - 1] + 1);
			if (i >= 4)
				minCnt = Math.min(minCnt, dp[i - 4] + 1);

			if (i >= 6)
				minCnt = Math.min(minCnt, dp[i - 6] + 1);

			dp[i] = minCnt;
		}
		
		
		System.out.println(dp[money]);
	}

}

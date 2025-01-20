package test03_knapsack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Knapsack {

	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 물건의 개수
		int W = Integer.parseInt(br.readLine()); // 배낭의 무게

		int[][] info = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][1] = Integer.parseInt(st.nextToken()); // cost
			info[i][0] = Integer.parseInt(st.nextToken()); // weight
		}

		int[][] dp = new int[N + 1][W + 1]; // i번째 물건까지 고려할거야

		// 물건은 한개씩만 존재

		for (int i = 1; i <= N; i++) {
			// w는 임시 무게
			for(int w = 0; w<=W; w++) {
				// 내가 고려할 물건의 무게가 임시무게보다 작다면...
				if(info[i][0] <= w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-info[i][0]] + info[i][1]);
				}else {
					// 아니라면 이전까지 고민한게 베스트
					dp[i][w] = dp[i-1][w];
				}
				
			}
			
		}// 물건 고려
		
		
		System.out.println(dp[N][W]);
	}
}

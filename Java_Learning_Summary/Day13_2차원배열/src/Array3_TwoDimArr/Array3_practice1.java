package Array3_TwoDimArr;

import java.util.Arrays;

// 25개 각 요소에 대해서 이웃한 요소와의 차이의 총합을 구하라

public class Array3_practice1 {

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int[][] arr;
	private static int N;
	private static int[][] sum;

	public static void main(String[] args) {
		
		N = 5;
		arr = new int[N][N];
		sum = new int[N][N];
		
//		Math.random(); 0 이상 1 미만의 실수
		for(int r = 0; r<N; r++) {
			for(int c= 0; c<N; c++) {
				arr[r][c] = (int) (Math.random() * 100);
			}
		}
		
		for(int r = 0; r<N; r++) {
			for(int c= 0; c<N; c++) {
				deltaQuest(r, c);
			}
		}
		
		System.out.println(Arrays.deepToString(sum));

		
	}
	
	public static void deltaQuest(int r, int c) {
		
		for(int i = 0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >= 0&& nr<N && nc>= 0 && nc < N) {
				sum[r][c] += Math.abs(arr[nr][nc]-arr[r][c]);
			}
		}
	
	}

}

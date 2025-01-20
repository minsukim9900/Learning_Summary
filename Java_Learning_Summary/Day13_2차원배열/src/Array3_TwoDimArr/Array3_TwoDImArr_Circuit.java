package Array3_TwoDimArr;

public class Array3_TwoDImArr_Circuit {

	public static void main(String[] args) {

		// n X m 배열의 n * m 개의 모든 원소를 빠짐 없이 조사하는 방법
		int N = 3;
		int M = 3;
		int[][] twoDimArr = new int[N][M];

		// 정방향 행 우선 순회
		int num = 1;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				twoDimArr[r][c] = num++;
				System.out.print(twoDimArr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		// 역방향 행 우선 순회
		
		for (int r = 0; r<N; r++) {
			for(int c= twoDimArr[r].length-1; c>=0; c--) {
				System.out.print(twoDimArr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();

		// 열 우선 순회
		
		for (int c = 0; c < M; c++) {
			for (int r = 0; r < N; r++) {
				System.out.print(twoDimArr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();

		// 지그제그 순회
		
		for (int r = 0; r < N; r++) {
			if (r % 2 == 0) {
				for (int c = 0; c < M; c++) {
					System.out.print(twoDimArr[r][c] + " ");
				}
			} else {
				for (int c = M - 1; c >= 0; c--) {
					System.out.print(twoDimArr[r][c] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();

		// 달팽이 순회
		int tmp = 1;
		
		for (int r = 0; r < N; r++) {
			
		}
	}

}

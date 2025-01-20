package Array3_TwoDimArr;

public class Array3_DeltaQuest {
	// 상, 하, 좌, 우 각 대각선
	private static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	private static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {

		int[][] arr = new int[3][3];

		int num = 1;
		// 배열 값 정의
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] = num++;
			}
		}

		// 델타를 이용한 2차원 배열 탐색

		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				deltaquest(arr, r, c);
				System.out.println();
			}
		}
	}

	public static void deltaquest(int[][] arr, int r, int c) {
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[r].length) {
				System.out.printf("%d방향, 값: %d, ", i, arr[nr][nc]);
			}
		}
	}

}

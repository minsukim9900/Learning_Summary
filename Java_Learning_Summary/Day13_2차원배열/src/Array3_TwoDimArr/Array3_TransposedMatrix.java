package Array3_TwoDimArr;

import java.util.Arrays;

public class Array3_TransposedMatrix {

	// 전치행렬
	public static void main(String[] args) {
		int[][] arr = new int[3][3];

		int num = 1;
		// 배열 값 정의
		
		for (int r = 0; r < arr.length; r++) {
			
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] = num++;
			}
			
		}
		System.out.println(Arrays.deepToString(arr));
		
		// 전치행렬 구현
		for (int r = 0; r < arr.length; r++) {
			
			for (int c = 0; c < arr[r].length; c++) {
				if(r < c) {
					int tmp = arr[r][c];
					arr[r][c] = arr[c][r];
					arr[c][r] = tmp;
				}
			}
			
		}
		
		System.out.println(Arrays.deepToString(arr));
		
		for(int r = 0; r<arr.length; r++) {
			
			for (int c = r+1; c<arr[r].length; c++) {
				int tmp = arr[r][c];
				arr[r][c] = arr[c][r];
				arr[c][r] = tmp;
			}
			
		}
		
		System.out.println(Arrays.deepToString(arr));

	}

}

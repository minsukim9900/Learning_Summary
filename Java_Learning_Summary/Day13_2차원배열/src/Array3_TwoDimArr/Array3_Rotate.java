package Array3_TwoDimArr;

import java.util.Arrays;

public class Array3_Rotate {
	
	public static void main(String[] args) {
		
		int[][] arr = new int[3][3];
		int[][] rotateArr = new int[3][3];

		int num = 1;
		// 배열 값 정의
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] = num++;
			}
		}
		
		for(int r = 0; r<arr.length; r++) {
			for(int c = 0; c<arr[r].length; c++) {
				rotateArr[r][c] = arr[arr[r].length-1-c][r];
			}
		}
		System.out.println(Arrays.deepToString(rotateArr));
	}
	
}

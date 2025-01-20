package Array;

import java.util.Arrays;

public class Array01_BubbleSort {
	public static void main(String[] args) {

		int[] arr = { 55, 7, 78, 12, 42 };
		int[] arr2 = { 55, 7, 78, 12, 42 };

		// 역방향 순회
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
			 System.out.println(Arrays.toString(arr));
		}
		 System.out.println(Arrays.toString(arr));


	}
}

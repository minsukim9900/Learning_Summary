package Array;

import java.util.Arrays;

public class Array06_Practice02 {
	//빈도수 구하기
	private static int[] intArray = { 3, 7, 2, 5, 7, 7, 9, 2, 8, 1, 1, 5, 3 };
	private static int[] nums = new int[10];

	public static void main(String[] args) {
		cntnums();
		System.out.println(Arrays.toString(nums));
	}

	private static void cntnums() {
		
		for (int i = 0; i <intArray.length; i++) {
			nums[intArray[i]]++;
		}
		
	}
	
	
}

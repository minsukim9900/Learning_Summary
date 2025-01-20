package test02_binary_search;

import java.util.Arrays;

public class BinarySearch_recursive {

	private static int[] arr = { 8, 9, 17, 21, 23, 35, 88, 369 };
	private static int key;

	public static void main(String[] args) {

		key = 19;
		System.out.println(binarySearch(0, arr.length-1));
		
		System.out.println(Arrays.binarySearch(arr, 17));

	}

	static boolean binarySearch(int left, int right) {
		// 기저조건
		if (left > right) {
			return false;
		}
		// 재귀 부분
		int mid = left / 2 + right / 2;
		
		// 같다면
		if(arr[mid] == key) return true;
		// 크다면
		else if(arr[mid] > key) {
			return binarySearch(left, mid-1);
		}
		// 작다면
		else {
			return binarySearch(mid+1, right);
		}

	}

}

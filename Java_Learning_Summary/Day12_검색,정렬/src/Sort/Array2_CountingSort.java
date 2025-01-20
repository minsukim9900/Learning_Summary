package Sort;

import java.util.Arrays;

public class Array2_CountingSort {
	
	
	public static void main(String[] args) {
		int[] arr = { 0, 4, 1, 3, 1, 2, 4, 1 };
		int[] result = new int[arr.length];
		int N = maxValue(arr);
		int[] count = new int[N+1];
		countValue(arr, count);
		prefixSum(arr, count);
		countingSort(arr, count, result);
		System.out.println(Arrays.toString(result));
	}

	static int maxValue(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}

	static void countValue(int[] arr, int[] count) {

		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

	}

	static void prefixSum(int[] arr, int[] count) {
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
	}
	
	static void countingSort(int[] arr, int[] count, int[] result) {
		for(int i = arr.length-1; i>=0; i--) {
			int tmp = arr[i];
			count[tmp]--;
			result[count[tmp]] = tmp;
		}
	}

}

package Sort;

import java.util.Arrays;

public class Array2_SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 64, 25, 10, 22, 11, 26 };
		selectionSort(arr, 0);
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int idx, int min_idx) {
		int tmp = arr[idx];
		arr[idx] = arr[min_idx];
		arr[min_idx] = tmp;
	}

	private static void selectionSort(int[] arr, int idx) {
		if (idx == arr.length - 1) {
			return;
		} else {

			int min = Integer.MAX_VALUE;
			int min_idx = 0;
			int i = idx;

			while (i < arr.length) {

				if (min > arr[i]) {
					min = arr[i];
					min_idx = i;
				}
				i++;
			}

			swap(arr, idx, min_idx);
			selectionSort(arr, idx + 1);
		}

	}

}

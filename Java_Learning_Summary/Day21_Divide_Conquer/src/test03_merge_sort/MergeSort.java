package test03_merge_sort;

import java.util.Arrays;

public class MergeSort {

	private static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
	private static int N = arr.length; // 배열의 길이
	private static int[] result = new int[N];

	public static void main(String[] args) {
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}

	// left : 구간의 시작 위치/ right : 구간의 끝
	private static void mergeSort(int left, int right) {

		if (left < right) {
			int mid = (left + right) /2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}

	}

	// left 시작 구간, mid 끝 구간, right 끝 구간
	private static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽구간의 시작 포인트
		int R = mid + 1; // 오른쪽 구간의 시작 포인트

		int idx = left;

		while (L <= mid && R <= right) {

			if (arr[L] <= arr[R]) {
				result[idx++] = arr[L++];
			} else {
				result[idx++] = arr[R++];
			}

		}

		if (L <= mid) {

			for (int i = L; i <= mid; i++) {
				result[idx++] = arr[i];
			}

		} else {

			for (int i = R; i <= right; i++) {
				result[idx++] = arr[i];
			}

		}
		
		System.out.println(left+" " + right);
		
		for (int i = left; i <= right; i++) {
			arr[i] = result[i];
		}

	}

}

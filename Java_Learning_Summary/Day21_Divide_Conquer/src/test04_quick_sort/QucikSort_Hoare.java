package test04_quick_hoare;

import java.util.Arrays;

public class QucikSort_Hoare {

	static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
	static int N = arr.length;

	public static void main(String[] args) {
		quickSort(0, N - 1);

		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int left, int right) {

		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}

	}

	// 반환 값은 피봇의 위치
	private static int partition(int left, int right) {
		int pivot = arr[left];
		int L = left + 1;
		int R = right;

		while (L <= R) {
			// L : Pivot 보다 큰 값을 찾을 때까지 이동
			while (L <= R && arr[L] <= pivot)
				L++;
			// R : pivot 보다 작거나 같은 값을 만날 때까지 이동
			while (arr[R] > pivot)
				R--;

			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}

		}

		// R의 위치는 사실 피봇이 가야할 위치이다.
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;

		return R;
	}

}

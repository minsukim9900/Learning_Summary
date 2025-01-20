package search;

public class Array2_BinarySearch {
	private static int result2;

	public static void main(String[] args) {
		int[] arr = { 2, 4, 7, 9, 11, 19, 23 };
		int value = 20;
		int result = binarySearch(arr, value);
		System.out.println(result);
		int left = 0;
		int right = arr.length - 1;
		binarySearch2(arr, left, right, value);
		System.out.println(result2);
	}

	static int binarySearch(int[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == value)
				return mid;
			else if (arr[mid] > value) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	static void binarySearch2(int[] arr, int left, int right, int value) {
		int mid = (left + right) / 2;

		if (left > right) {
			result2 = -1;
		}

		else if (arr[mid] == value)
			result2 = mid;
		else if (arr[mid] > value)
			binarySearch2(arr, left, mid - 1, value);
		else
			binarySearch2(arr, mid + 1, right, value);

	}

}

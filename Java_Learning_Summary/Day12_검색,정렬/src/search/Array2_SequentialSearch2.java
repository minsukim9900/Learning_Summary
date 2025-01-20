package search;

public class Array2_SequentialSearch2 {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 7, 9, 11, 19, 23 };

		int value = 11;
		int result = searchForSort(arr, value);
		int result2 = searchWhileSort(arr, value);
		
		System.out.println(result);
		System.out.println(result2);

	}
	
	// 정렬 안한 경우
	// 비교 횟수 1
	// 반복문이 많이 돌 가능성이 높다.
	
	// 정렬 한 경우
	// 비교 횟수 2
	// 반복문이 적게 돌 가능성이 높다.

	static int searchForSort(int[] arr, int value) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > value) {
				return -1;
			} else if (arr[i] == value)
				return i;
		}

		return -1;
	}

	static int searchWhileSort(int[] arr, int value) {

		int i = 0;
		while (i < arr.length) {
			if (arr[i] == value) {
				return i;
			} else if (arr[i] > value)
				return -1;
			i++;
		}

		return -1;
	}
}

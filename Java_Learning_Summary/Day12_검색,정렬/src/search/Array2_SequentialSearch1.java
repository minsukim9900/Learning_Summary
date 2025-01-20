package search;

public class Array2_SequentialSearch1 {

	public static void main(String[] args) {
		int[] arr = { 4, 9, 11, 23, 2, 19, 7 };
		int value = 7;
		int result = searchForNoSort(arr, value);
		int result2 = searchWhileNoSort(arr, value);
		
		System.out.println(result);
		System.out.println(result2);
	}

	// 찾고자하는 value의 index를 return
	static int searchForNoSort(int[] arr, int value) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}

		return -1;

	}

	static int searchWhileNoSort(int[] arr, int value) {
		int i = 0;

		while (i < arr.length) {
			if (arr[i] == value)
				return i;
			i++;
		}

		return -1;
	}

}

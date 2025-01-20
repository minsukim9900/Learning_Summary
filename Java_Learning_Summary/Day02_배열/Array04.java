package Array;

import java.util.Arrays;

public class Array04 {
	// 배열의 복사
	public static void main(String[] args) {
		int[] nums = { 1, 4, 6, 1, 4 };
		String[] fruits = { "pig", "date", "plum" };
		int[] tmp = new int[nums.length * 2];

		// 반복문을 통한 복사
		// 1. 먼저 빈 배열 만들기
		for (int i = 0; i < nums.length; i++) {
			// 반복문을 순회하면서, 각 우너소의 값 옮기기
			tmp[i] = nums[i];
		}

		System.out.println(Arrays.toString(tmp));

		// Arrays.copyOf(원본배열, 새로운배열의 크기)
		int[] tmp2 = Arrays.copyOf(nums, nums.length*2);
		System.out.println(Arrays.toString(tmp2));
		
		// Arrays.copyOfRange(원본배열, 시작점, 끝 인덱스)
		int[] tmp3 = Arrays.copyOfRange(nums,0,nums.length*2);
		System.out.println(Arrays.toString(tmp3));
		
		// System.arraycopy(원본배열, 원본배열의 시작점, 복사배열, 복사배열의 시작점, 복사할 길이(갯수))
		int[] tmp4 = new int[nums.length*2];
		System.arraycopy(nums, 0, tmp4, 0, nums.length);
		System.out.println(Arrays.toString(tmp4));
	}
}

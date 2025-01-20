package test01_powerset;

import java.util.Arrays;

public class PowerSet_for {

	private static int[] nums = { 1, 2, 3, 4 };
	private static int N = 4;

	// 해당 인덱스의 재료를 사용했는지의 유무를 저장하는 배열
	private static int[] sel = new int[N];

	public static void main(String[] args) {

		// 재료가 4개! 반복문은 몇 개? => 4개
		for (int i = 0; i <= 1; i++) {
			sel[0] = i;
			for (int j = 0; j <= 1; j++) {
				sel[1] = j;
				for (int k = 0; k <= 1; k++) {
					sel[2] = k;
					for (int l = 0; l <= 1; l++) {
						sel[3] = l;
						System.out.println(Arrays.toString(sel));
					}
				}

			}
		}
		
		

	}

}

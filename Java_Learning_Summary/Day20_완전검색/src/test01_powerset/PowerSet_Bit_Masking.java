package test01_powerset;

import java.util.Arrays;

public class PowerSet_Bit_Masking {

	private static String[] 재료 = { "단무지", "햄", "오이", "시금치" };
	private static int N = 4;

	// 해당 인덱스의 재료를 사용했는지의 유무를 저장하는 배열
	private static int[] sel = new int[N];

	public static void main(String[] args) {

		// 2의 N승만큼 반복한다.
		for (int i = 0; i < (1 << N); i++) {
			// i는 하나의 김밥 종류다.
			// 재료 확인 for문이 필요
			String tmp = "";
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					// 해당 재료가 있어요~~
					tmp += 재료[j];
				}
			}
			System.out.println(tmp);
		}

	}

}

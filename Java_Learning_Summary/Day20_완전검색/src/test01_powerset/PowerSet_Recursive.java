package test01_powerset;

import java.util.Arrays;

public class PowerSet_Recursive {

	private static String[] 재료 = { "단무지", "햄", "오이", "시금치" };
	private static int N;

	// 해당 인덱스의 재료를 사용했는지의 유무를 저장하는 배열
	private static boolean[] sel;

	public static void main(String[] args) {

		N = 4;
		sel = new boolean[N];
		powerset(0);
	}

	public static void powerset(int idx) {
		if(idx == N) {
			String tmp = "김밥 : ";
			for(int i = 0; i<N; i++) {
				if(sel[i]) {
					tmp += 재료[i];
					tmp += ", ";
					
				}
			}
			System.out.println(tmp);
			
		}else {
			
			sel[idx] = false;
			powerset(idx+1);
			sel[idx] = true;
			powerset(idx+1);
			
		}
		
	}

}

package test01_permutaion_dupl;

import java.util.Arrays;

public class Permutation_dupl {
	static int[] nums;
	static int N;
	static int[] result;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		result = new int[N];
		
		perm(0);
		

	}

	private static void perm(int depth) {
		
		if(depth == N) {
			System.out.println(Arrays.toString(result));
		}else {
			
			for(int i = 0; i<N; i++){
				result[depth] = nums[i];
				perm(depth+1);
			}
			
		}
		
	}

}

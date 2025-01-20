package test02_permutation;

import java.util.Arrays;

public class Permutation_bitmasking {
	static int[] nums;
	static int N;
	static int[] result;

	public static void main(String[] args) {

		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		result = new int[N];
		perm(0,0);

	}
	
	static void perm(int depth, int visited) {
		
		if ( visited == (1<<N) - 1 ) {
			System.out.println(Arrays.toString(result));
		}
		
		for(int i = 0; i<N; i++) {
			if((visited & (1<<i)) != 0) continue;
			result[depth] = nums[i];
			perm(depth+1, visited | (1<<i));
			
		}
		
	}
}

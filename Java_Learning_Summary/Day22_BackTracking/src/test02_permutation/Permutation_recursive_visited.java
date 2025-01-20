package test02_permutation;

import java.util.Arrays;

public class Permutation_recursive_visited {
	static int[] nums;
	static int N;
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) {

		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		perm(0);

	}

	// depth : 현재 판단 위치
	static void perm(int depth) {
		if (depth == N) {
			System.out.println(Arrays.toString(result));
		}

		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] =  true;
				result[depth] = nums[i];
				perm(depth+1);
				visited[i] = false;
			}
		}

	}
}

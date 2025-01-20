package test02_combination;

public class Combination_Recursive {

	private static String[] 재료 = { "상추", "패티", "토마토", "치즈" };
	private static int N, R; // N : 재료의 수, R, 내가 뽑고 싶은 재료의 수
	private static String[] result;

	public static void main(String[] args) {
		N = 4;
		R = 2;
		result = new String[R];
		dfs(0, 0);
	}

	private static void dfs(int num, int depth) {

		if (depth == R) {

			for (String w : result) {
				System.out.print(w + " ");
			}
			System.out.println();

		} else {

			for (int i = num; i <= N-R+depth; i++) {
				result[depth] = 재료[i];
				dfs(i + 1, depth + 1);
			}

		}

	}
}

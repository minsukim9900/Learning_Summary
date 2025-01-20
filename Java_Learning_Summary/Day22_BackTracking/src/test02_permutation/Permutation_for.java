package test02_permutation;

public class Permutation_for {
	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 1, 2, 3 };

		N = nums.length;

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				if (i != j) {

					for (int k = 0; k < N; k++) {

						if (k != i && k != j) {
							System.out.printf("%d, %d, %d\n", nums[i], nums[j], nums[k]);
						}

					}

				}

			}

		}

	}
}

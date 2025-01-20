package Array;

public class Array05_Practice01 {
	private static int[] nums = { 64, 53, 123, 23, 444, 98, 12 };

	public static void main(String[] args) {
		int a = arrMax();
		int b = arrMin();
		int c = arrSum();
		double d = arrAvg();
		System.out.printf("%d, %d, %d, %.2f", a ,b, c, d);
	}

	private static int arrMax() {
		int max = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}

		return max;
	}

	private static int arrMin() {
		int min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (min > nums[i]) {
				min = nums[i];
			}
		}

		return min;
	}
	
	private static int arrSum() {
		int sum = 0;
		for(int i = 0; i<nums.length; i++) {
			sum += nums[i];
		}
		
		return sum;
	}
	
	private static double arrAvg() {
		double sum = 0;
		for(int i = 0; i<nums.length; i++) {
			sum += nums[i];
		}
		
		double avg = sum / nums.length;
		
		return avg;
	}
}

package Array;

public class Array08_Practice03 {
	//모든 2차원 배열의 원소 중 3의 배수의 개수와 그들의 합을 출력
	private static int[][] grid = { {2,3,1,4,7},
			{8,13,3,33,1},
			{7,4,5,80,12},
			{17,9,11,5,4},
			{4,5,91,27,7}
	};
	private static int cnt = 0;
	private static int sum = 0;
	
	public static void main(String[] args) {
		cntGrid();
		System.out.println(cnt);
		System.out.println(sum);
	}
	
	private static void cntGrid() {
		for(int r = 0; r<grid.length; r++) {
			for(int c = 0; c<grid[r].length; c++) {
				if(grid[r][c] % 3 == 0) {
					cnt++;
					sum += grid[r][c];
				}
			}
		}
	}
	
}

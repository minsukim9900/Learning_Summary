package Array;

import java.util.Arrays;

public class Array07 {
	//2차원 배열 선언 및 생성
	public static void main(String[] args) {
		int[][] arr1; //선언만 한 것,
		
		int[][] arr2 = new int[3][4]; //3행 4열인 배열
		
		// 다차원배열 출력할 때는
		System.out.println(Arrays.deepToString(arr2));
		
		//2차원 배열을 생성할 때는 2차원 배열의 길이만 지정하면 된다.
		//2차원 배열: 1차원 배열의 참조값을 요소로 갖는 배열.
		//1차원에는 null이 들어감
		int[][] arr3 = new int[3][];
		System.out.println(Arrays.deepToString(arr3));
		arr3[0]= new int[10];
		arr3[1]= new int[4];
		arr3[2]= new int[9];
		
		System.out.println(Arrays.deepToString(arr3));
		
	}
}

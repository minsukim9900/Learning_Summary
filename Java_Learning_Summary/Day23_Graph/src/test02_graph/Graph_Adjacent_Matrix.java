package test02_graph;

import java.util.Scanner;

public class Graph_Adjacent_Matrix {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// V, E의 개수를 준다.
		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int W = 1; // 가중치가 있따면 W에 값을 넣는다.
			
			adjArr[from][to] = adjArr[to][from] = W; // 무향이라면 반대의 경우도 같이 작성
			 
			
		}// E개의 간선을 입력 받을 반복문

	}

}

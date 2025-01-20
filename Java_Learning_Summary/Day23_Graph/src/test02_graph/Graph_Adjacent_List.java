package test02_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph_Adjacent_List {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// V, E의 개수를 준다.
		int V = sc.nextInt();
		int E = sc.nextInt();

		List<int[]>[] adjList = new ArrayList[V+1];
		for(int i = 0; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int W = 1;
			
			adjList[from].add(new int[] {to, W});
			adjList[to].add(new int[] {to,W});
		}

	}

}

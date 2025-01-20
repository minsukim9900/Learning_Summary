package test02_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph_Edge_Array {

	static class Edge {
		int From, To, W; // 시작, 끝, 가중치

		public Edge(int from, int to, int w) {
			super();
			From = from;
			To = to;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [From=" + From + ", To=" + To + ", W=" + W + "]";
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// V, E의 개수를 준다.
		int V = sc.nextInt();
		int E = sc.nextInt();

		Edge[] edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int W = sc.nextInt();

			edges[i] = new Edge(from, to, W);
		}

		List<Edge> edges2 = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int w = sc.nextInt();
			edges2.add(new Edge(from, to, w));
		}

		int[][] edges3 = new int[E][3];

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int w = sc.nextInt();

			edges3[i][0] = from;
			edges3[i][1] = to;
			edges3[i][2] = w;
		}

	}

}

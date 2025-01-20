package test02_dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Dijkstra_for {

	static class Node {
		int V, W;

		public Node(int v, int w) {
			super();
			V = v;
			W = w;
		}

	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adj;
	static int[] dist;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adj = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}

		dist = new int[V];
		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[x].add(new Node(y, w));
		} // 입력 완료

		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
	}

	private static void dijkstra(int st) {
		boolean[] visited = new boolean[V];

		dist[st] = 0; // 시작 노드까지의 거리는 0으로 초기화

		// 어디까지 할지는 문제를 보고 결정
		for (int i = 0; i < V; i++) {
			int min = INF;
			int idx = -1;

			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			// 해당 조건문의 의미? 갈 수 있는게 없다...
			if(idx == -1) {
				break;
			}
			
			visited[idx] = true;
			
			for(Node node : adj[idx]) {
				if(!visited[node.V] && dist[node.V] > dist[idx] + node.W) {
					dist[node.V] = dist[idx] + node.W;
				}
			}
			
		}

	}
}

package test02_dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_PriorityQueue {

	static class Node {
		int y, w;

		public Node(int y, int w) {
			super();
			this.y = y;
			this.w = w;
		}

	}

	static class PqFormat implements Comparable<PqFormat> {
		int index, dist;

		public PqFormat(int index, int dist) {
			super();
			this.index = index;
			this.dist = dist;
		}

		@Override
		public int compareTo(PqFormat o) {
			return Integer.compare(this.dist, o.dist);
		}
		
	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adj;
	static int[] dist;
	static boolean[] visited;

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

		visited = new boolean[V];
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
		PriorityQueue<PqFormat> pq = new PriorityQueue<>();
		
		pq.add(new PqFormat(st, 0));
		dist[st] = 0;
		int pick = 0;

		while (pick != V ) {
			PqFormat now = pq.poll();
			if(visited[now.index]) continue;
			
			visited[now.index] = true;
			
			for(Node node : adj[now.index]) {
				if(dist[node.y] > dist[now.index] + node.w) {
					dist[node.y] = dist[now.index] + node.w;
					pq.offer(new PqFormat(node.y, dist[node.y]));
				}
			}
			
			pick++;
			

		}
	}
}

package test01_prim;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim_PriorityQueue {

	private static class Edge implements Comparable<Edge> {
		int x, y, w;

		public Edge(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		// 인접 리스트
		List<Edge>[] adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[x].add(new Edge(x, y, w));
			adjList[y].add(new Edge(y, x, w));
		}

		// 방문체크
		boolean[] visited = new boolean[V];

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited[0] = true;
		
		int ans = 0;
		int pick = 1;
		
		for(Edge e : adjList[0]) {
			pq.add(e);
		}
		
		while(pick != V) {
			Edge e = pq.poll();
			if(visited[e.y]) continue; // 이미 뽑은 친구라면?
			
			ans += e.w;
			visited[e.y] = true;
			pick++;
			
			pq.addAll(adjList[e.y]);
		}
		System.out.println(ans);
	}

}

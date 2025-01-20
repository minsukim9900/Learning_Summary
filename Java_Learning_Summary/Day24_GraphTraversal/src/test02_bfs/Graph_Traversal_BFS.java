package test02_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Graph_Traversal_BFS {

	static int V, E; // 정점의 갯수, 간선의 갯수
	static List<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[V+1];
		for(int i = 1; i<=V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adj[from].add(to);
			adj[to].add(from);

		}
		
		BFS(1);

	}
	
	private static void BFS(int v) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(v);
		visited[v] = true;
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.println(curr);
			
			for(int w : adj[curr]) {
				if(!visited[w]) {
					visited[w] = true;
					queue.add(w);
				}
			}
			
		}
	}

}

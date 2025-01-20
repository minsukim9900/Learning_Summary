package test01_dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Graph_Traversal_DFS {
	
	private static Stack<Integer> stack = new Stack<>();
	static int V, E; // 정점의 갯수, 간선의 갯수
	static int[][] adj;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adj = new int[V+1][V+1];
		visited = new boolean[V+1];
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adj[from][to] = 1;
			adj[to][from] = 1;
		}
		
		DFS(1);
		
	}
	
	// 현재 내가 있는 정점
	static void DFS(int v) {
		stack.push(v);
		visited[v] = true;
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			System.out.println(curr);
			for(int i = 1; i<=V; i++) {
				if( !visited[i] && adj[curr][i] == 1) {
					visited[i] = true;
					stack.push(i);
				}
			}
		}
		
	}
}

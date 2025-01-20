package test01_mst;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MST_KRUSKAL {

	private static class Edge implements Comparable<Edge> {
		int from, to, w;

		public Edge(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		

		
	}
	
	private static int[] p; // 대표자를 저장할 배열

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[E];
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); 
			
			edges[i] = new Edge(from, to, w);
		}
		
		//크루스칼 제 1장 : 가중치 순으로 정렬을 해라!
		Arrays.sort(edges);
		
		// 크루스칼 제 2장 : V-1개의 간선을 뽑아라! ( 사이클이 발생하지 않게 )
		// 상호배타 집합(서로소집합, 유니온파인드)
		p = new int[V]; // 0번부터 시작하길래 ㅎ
		
		//make-set을 통해 전체 자신을 대표로 만드는 작업을 수행한다.
		for(int i = 0; i<V; i++) {
			p[i] = i;
		}
		
		int ans = 0;
		int pick = 0;
		
		for(int i = 0; i<E; i++) {
//			int x = edges[i].from;
//			int y = edges[i].to;
//			
//			// 사이클이 발생하는지 검사를 해야한다.
//			if(findSet(x) != findSet(y)) {
//				// 해당 블록에 들어왔다면... 사이클이 아니라는 뜻
//				union(x, y);
//				ans += edges[i].w;
//				pick++;
//			}
			
			int px = findSet(edges[i].from);
			int py = findSet(edges[i].to);
			if(px != py) {
				union(px, py);
				ans += edges[i].w;
				pick++;
			}
			
			
			
			if(pick == (V-1)) break;
			
		} // 간선의 총 갯수 만큼 돌면서...
		
		System.out.println(ans);
		
		
	}
	
	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
		
		if(x != p[x]){
			p[x] = findSet(p[x]);
		}
		
		return p[x];
	}
	
	static void union(int x, int y) {
		//p[findSet(y)] = findSet(x); // x그룹에 y그릅을 넣는것
		p[y] = x;
	}

}

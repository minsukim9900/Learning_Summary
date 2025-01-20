package test01_prim;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prim_for {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjArr[x][y] = adjArr[y][x] = w; // 무향
		}

		// 방문체크
		boolean[] visited = new boolean[V];
		int[] p = new int[V]; // 내 부모는 사용하지 않을거라면 굳이 작성하지 않아도 OK
		int[] dist = new int[V];

		// 프림 제 1장 : 초기화
		for (int i = 0; i < V; i++) {
			p[i] = -1;
			dist[i] = INF;
		}

		// 프림 제 2장 : 시작정점을 결정
		dist[6] = 0;

		// 프림 제 3장 : 가중치 배열을 돌면서 가장 값이 낮은것을 골라서 방문 체크 / 갱신
		int ans  = 0;
		for (int i = 0; i < V; i++) {
			// 방문 하지 않았으면서 가장 작은 값 가져와
			int min = INF;
			int idx = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			// 해당 반복문이 종료가 되면.. idx는 가장 작은 값을 가지고 있어
			visited[idx] = true;
			ans += dist[idx];

			// 방문하지 않았고 갱신할 수 있으면 갱신해
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;
				}
			}

		}


		System.out.println(ans);

	}

}

package test02_Stack_Topological;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Topological_Stack {

	private static int V, E;
	private static int[][] adjArr;
	private static int[] degree;
	private static boolean[] visited;
	private static Stack<Integer> ans;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjArr = new int[V + 1][V + 1];
		degree = new int[V + 1];
		visited = new boolean[V + 1];

		ans = new Stack<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjArr[from][to] = 1;
			degree[to]++;
		}

		for (int i = 1; i < V + 1; i++) {
			if (degree[i] == 0) {
				dfs(i);
			}
		}// 위상 정렬 완료
		
		while(!ans.isEmpty()) {
			System.out.print(ans.pop()+" ");
		}

	}

	private static void dfs(int curr) {
		visited[curr] = true;
		// 오해 포인트! : 방문을 했다고 해서 무조건 출력을 해서는 안된다.
		// 아직 선행 조건이 남아 있을 수 있음.
		for (int i = 1; i < V + 1; i++) {
			// 간선이 연결되어 있고, 방문하지 않았다면...
			if (adjArr[curr][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}

		///////////////////////////////
		ans.push(curr); // 연결되어 있는 모든 정점을 다 방문하였어..

	}
}

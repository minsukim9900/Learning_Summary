package test01_Queue_Topological;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Topological_Queue {

	private static int N, M;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] adjArr = new int[N + 1][N + 1];
		int[] degree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjArr[from][to] = 1;
			// 진입차수를 증가!
			degree[to]++;
		} // 입력 완료

		// 위상정렬 큐 1장 : 진입차수가 0인 친구들을 몽땅 넣어라
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				q.add(i);
			}
		}

		// 위상정렬 큐 2장 : 큐가 공백상태가 될 떄까지 진행
		// 뽑았을때 간선을 제거하고, 진입차수가 0이되면 새롭게 큐에 넣는다.
		
		StringBuilder sb = new StringBuilder();
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			
			for (int i = 1; i <= N; i++) {
				if (adjArr[curr][i] == 1) {
					degree[i]--; // 진입차수하나 깍아.
					adjArr[curr][i] = 0;
					// 만약 이번 i 정점의 진입 차수가 0이 되었다면..
					if(degree[i] == 0) {
						q.add(i);
					}
				}
			}
		}
		
		System.out.println(sb.toString());

	}
}

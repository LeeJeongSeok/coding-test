package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 플로이드-와샬
 */

public class _11403_ {

	static int[][] graph;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		// i에서 k로, k에서 j로 갈수있는가?
		// k = 거쳐가는 노드, i = 출발노드, j = 도착노드
		// ex) 1번 노드를 거쳐간다는 가정하에
		// 2번 노드에서 1번노드를 거쳐가고, 1번 노드에서 3번노드로 거쳐가냐?를 묻는 문제임
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(graph[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

}

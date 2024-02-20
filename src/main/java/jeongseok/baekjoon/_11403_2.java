package jeongseok.baekjoon;

/**
 * 플로이드-와샬 기본 문제
 *
 * 왜 이문제가 플로이드-와샬인지를 먼저 분석해보면
 * 모든 정점 (i, j)에 대해서 i에서 j로 가는 길이 있는지 없는지를 판별한다고 나와있다.
 *
 * 기본적으로 플로이드-와샬은 '모든 정점'에서 '모든 정점'으로의 최단 경로가 있는지
 * 를 파악하는 이론이다.
 *
 * 이 문제는 최단경로를 묻는게 아닌 경로가 있는지만 판별한다.
 * 최단경로를 구하면서 그 최단경로가 경로의 유무를 판별할 수 있기 때문에
 * 플로이드-와샬 알고리즘으로 풀 수 있다.
 *
 * 플로이드 와샬에서 핵심은 한줄로 끝난다.
 * X에서 Y로 가는 최소 비용 vs X에서 노드 1로 가는 비용 + 노드 1에서 Y로 가는 비용
 *
 */

import java.io.*;
import java.util.StringTokenizer;

public class _11403_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		floydWarshall(N, graph);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(graph[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void floydWarshall(int N, int[][] graph) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}
				}
			}
		}
	}

}

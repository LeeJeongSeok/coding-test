package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _15649_ {

	static int N, M;
	static int[] arr, result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		arr = new int[N];
		result = new int[M];

		for (int i = 1; i <= N; i++) {
			arr[i - 1] = i;
		}

		dfs(0);

		System.out.println(sb.toString());
	}

	private static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					result[depth] = arr[i];
					dfs(depth + 1);
					visited[i] = false;
				}
			}
		}
	}
}

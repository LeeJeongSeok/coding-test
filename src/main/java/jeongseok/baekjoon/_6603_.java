package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _6603_ {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());

			if (K == 0) {
				System.out.println(sb.toString());
				break;
			}

			int[] arr = new int[K];
			int[] result = new int[6];
			boolean[] visited = new boolean[K];

			for (int i = 0; i < K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0, K, arr, result, visited);
			sb.append("\n");
		}
	}

	private static void dfs(int depth, int start, int K, int[] arr, int[] result, boolean[] visited) {
		if (depth == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = start; i < K; i++) {
				if (!visited[i]) {
					visited[i] = true;
					result[depth] = arr[i];
					dfs(depth + 1, i + 1, K, arr, result, visited);
					visited[i] = false;
				}
			}
		}
	}

}

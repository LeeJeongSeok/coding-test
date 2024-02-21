package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _15650_2 {

	static int N, M;
	static int[] arr, result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		dfs(0, 0);

		System.out.println(sb.toString());
	}

	private static void dfs(int start, int depth) {
		if (depth == M) {
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = start; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					result[depth] = arr[i];
					dfs(i, depth + 1);
					visited[i] = false;
				}
			}
		}
	}

}

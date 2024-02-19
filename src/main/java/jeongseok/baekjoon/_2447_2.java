package jeongseok.baekjoon;

import java.io.*;

public class _2447_2 {

	static int N;
	static char[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		dfs(0, 0, N, false);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void dfs(int row, int col, int N, boolean isCenter) {
		if (isCenter) {
			for (int i = row; i < row + N; i++) {
				for (int j = col; j < col + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}

		if (N == 1) {
			arr[row][col] = '*';
			return;
		}

		int newSize = N / 3;
		int count = 0;

		for (int i = row; i < row + N; i += newSize) {
			for (int j = col; j < col + N; j += newSize) {
				count++;
				if (count == 5) {
					dfs(i, j, newSize, true);
				} else {
					dfs(i, j, newSize, false);
				}
			}
		}
	}

}

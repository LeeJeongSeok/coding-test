package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _1992_2 {

	static int[][] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < split.length; j++) {
				arr[i][j] = Integer.parseInt(split[j]);
			}
		}

		rec_func(0, 0, N);

		System.out.println(sb.toString());

	}

	private static void rec_func(int row, int col, int size) {

		if (isSame(row, col, size)) {
			sb.append(arr[row][col]);
			return;
		}

		int newSize = size / 2;

		sb.append("(");
		// 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순으로 탐색
		rec_func(row, col, newSize);
		rec_func(row, col + newSize, newSize);
		rec_func(row + newSize, col, newSize);
		rec_func(row + newSize, col + newSize, newSize);

		sb.append(")");
	}

	private static boolean isSame(int row, int col, int size) {
		int current = arr[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (current != arr[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}

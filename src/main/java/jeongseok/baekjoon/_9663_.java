package jeongseok.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * N-Queen
 * N * N인 체스판 위에 Queen N개를 서로 공격할 수 없는 위치에 놓는 문제이다.
 *
 * 일단 퀸이 이동할 수 있는 방향은 상하좌우, 대각선 모든 방향 (8방향) 다 가능하고
 * 무제한 이동이 가능하다.
 *
 * 1차원 배열에서 index를 '열', 원소 값을 '행'
 */
public class _9663_ {

	static int[] arr;
	static int N, count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		dfs(0);
		System.out.println(count);
	}

	private static void dfs(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i;

			if (Possibility(depth)) {
				dfs(depth + 1);
			}
		}
	}

	private static boolean Possibility(int col) {
		for (int i = 0; i < col; i++) {
			// 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우)
			if (arr[col] == arr[i]) {
				return false;
			}

			/*
			 * 대각선상에 놓여있는 경우
			 * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
			 */
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}

		return true;
	}


}

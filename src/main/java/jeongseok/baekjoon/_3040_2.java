package jeongseok.baekjoon;

/**
 * 9명의 난쟁이중 7명의 난쟁이를 뽑아서 전체 합이 100인지를 판별하면 됨
 * 입력으로 주어지는 수들을 더해서 100이 되었을 때 그 수가 유일한 경우이다.
 */

import java.io.*;
import java.util.*;

public class _3040_2 {

	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9];
		visited = new boolean[9];
		result = new int[7];

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dfs(0);
	}

	// start 변수를 추가로 만들어서 활용한다면 굳이 visited 배열을 사용하지 않아도 된다.
	private static void dfs(int depth) {
		if (depth == 7) {
			if (isAnswer()) {
				for (int i = 0; i < 7; i++) {
					System.out.println(result[i]);
				}
				System.exit(0);
			}
		} else {
			for (int i = 0; i < 9; i++) {
				if (!visited[i]) {
					visited[i] = true;
					result[depth] = arr[i];
					dfs(depth + 1);
					visited[i] = false;
				}
			}
		}
	}

	private static boolean isAnswer() {
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += result[i];
		}

		if (sum != 100) {
			return false;
		}

		return true;
	}

}

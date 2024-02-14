package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _3040_ {

	static int[] arr = new int[9];
	static int[] result = new int[7];
	static boolean[] visited = new boolean[9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		rec_func(0);
	}

	private static void rec_func(int depth) {
		if (depth == 7) {
			if (calculate() == 100) {
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
				System.exit(0); // 종료조건 처리가 미숙하다.
			}
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					result[depth] = arr[i];
					rec_func(depth + 1);
					visited[i] = false;
				}
			}
		}
	}

	private static int calculate() {
		int sum = 0;
		for (int i = 0; i < result.length; i++) {
			sum += result[i];
		}

		return sum;
	}
}

package jeongseok.baekjoon;

/**
 * 10
 * 6 3 2 10 10 10 -10 -10 7 3
 * 8
 * 10 9 -5 2 3 4 5 -10
 * 2024.02.07
 */

import java.util.*;
import java.io.*;

public class _10816_ {

	static HashMap<Integer, Integer> map = new HashMap<>();
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			if (map.containsKey(key)) {
				sb.append(map.get(key)).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}

		System.out.println(sb.toString());
	}
}

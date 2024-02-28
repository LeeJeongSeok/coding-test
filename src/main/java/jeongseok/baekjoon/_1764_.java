package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _1764_ {

	static int N, M, count;
	static TreeMap<String, Integer> map = new TreeMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + M; i++) {
			String key = br.readLine();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		for (String key : map.keySet()) {
			if (map.get(key) == 2) {
				sb.append(key).append("\n");
				count++;
			}
		}

		System.out.println(count);
		System.out.println(sb.toString());
	}

}

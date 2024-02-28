package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _14425_ {

	static int N, M, count;
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String key = br.readLine();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		for (int i = 0; i < M; i++) {
			String key = br.readLine();
			if (map.containsKey(key)) {
				count++;
			}
		}

		System.out.println(count);
	}

}

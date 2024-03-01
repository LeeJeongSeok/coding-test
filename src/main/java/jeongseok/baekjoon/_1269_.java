package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _1269_ {

	static int A, B, result;
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		for (Integer value : map.values()) {
			if (value == 2) {
				continue;
			}
			result++;
		}

		System.out.println(result);
	}

}

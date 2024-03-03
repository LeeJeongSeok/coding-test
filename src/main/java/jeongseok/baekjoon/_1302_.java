package jeongseok.baekjoon;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class _1302_ {

	static int N;
	static TreeMap<String, Integer> map = new TreeMap<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			String key = br.readLine();
			map.put(key, map.getOrDefault(key, 0) + 1);
			max = Math.max(max, map.get(key));
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				System.out.println(entry.getKey());
				return;
			}
		}
	}

}

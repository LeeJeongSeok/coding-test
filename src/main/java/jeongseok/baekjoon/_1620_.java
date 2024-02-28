package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _1620_ {

	static int N, M;
	static HashMap<Integer, String> mappedToNumber = new HashMap<>();
	static HashMap<String, Integer> mappedToName = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			mappedToNumber.put(i + 1, name);
			mappedToName.put(name, i + 1);
		}

		for (int i = 0; i < M; i++) {
			String problem = br.readLine();
			if (problem.matches("[+-]?\\d*(\\.\\d+)?")) {
				int key = Integer.parseInt(problem);
				sb.append(mappedToNumber.get(key)).append("\n");
			} else {
				sb.append(mappedToName.get(problem)).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}

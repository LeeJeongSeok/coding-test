package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _17219_ {

	static int N, M;
	static HashMap<String, String> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String url = st.nextToken();
			String password = st.nextToken();

			map.put(url, password);
		}

		for (int i = 0; i < M; i++) {
			String url = br.readLine();
			sb.append(map.get(url)).append("\n");
		}

		System.out.println(sb.toString());
	}

}

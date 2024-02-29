package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _9375_ {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			int N = Integer.parseInt(br.readLine());

			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String item = st.nextToken();
				String key = st.nextToken();
				map.put(key, map.getOrDefault(key, 0) + 1);
			}

			int result = 1;

			for (Integer value : map.values()) {
				result *= (value + 1);
			}

			System.out.println(result - 1);
		}
	}

}

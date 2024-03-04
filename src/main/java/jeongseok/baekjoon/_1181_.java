package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _1181_ {

	static int N;
	static String[] S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		S = new String[N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			S[i] = str;
		}

		Arrays.sort(S, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});

		System.out.println(S[0]);
		for (int i = 1; i < S.length; i++) {
			if (!S[i].equals(S[i - 1])) {
				System.out.println(S[i]);
			}
		}
	}

}

package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _11478_ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < S.length(); i++) {
			for (int j = i + 1; j <= S.length(); j++) {
				set.add(S.substring(i, j)); // endIndex - beginIndex
			}
		}

		System.out.println(set.size());
	}

}

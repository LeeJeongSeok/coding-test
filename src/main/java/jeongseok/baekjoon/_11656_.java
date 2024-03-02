package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _11656_ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < S.length(); i++) {
			list.add(S.substring(i, S.length()));
		}

		Collections.sort(list);

		for (String s : list) {
			System.out.println(s);
		}
	}

}

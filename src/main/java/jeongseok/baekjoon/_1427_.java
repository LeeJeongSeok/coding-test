package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _1427_ {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		String[] str = N.split("");

		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -(o1.compareTo(o2));
			}
		});

		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
	}
}

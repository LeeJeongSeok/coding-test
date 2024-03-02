package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _11478_ {

	static int count;
	static String S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();

		int left = 0;
		int right = 0;

		while (right != S.length() - 1) {
			int tempLeft = left;
			int tempRight = right;

			while (true) {

				if (tempRight == S.length() - 1) {
					count++;
					break;
				}

				count++;
				tempLeft++;
				tempRight++;
			}

			right++;
		}

		System.out.println(count);
	}

}

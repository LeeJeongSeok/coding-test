package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _1789_2 {

	static long N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Long.parseLong(br.readLine());

		long sum = 0;
		long count = 0;

		for (int i = 1; ; i++) {
			if (sum > N) {
				break;
			} else {
				sum += i;
				count++;
			}
		}

		System.out.println(count - 1);
	}

}

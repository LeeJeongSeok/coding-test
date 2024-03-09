package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _2217_ {

	static int N, count;
	static int[] arr;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = N;
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i] * count);
			count--;
		}

		System.out.println(max);

	}

}

package jeongseok.baekjoon;

/**
 * 5
 * 2 4 -10 4 -9
 *
 * 2 3 0 3 1
 */

import java.io.*;
import java.util.*;

public class _18870_2 {

	static int N;
	static int[] arr, sorted;
	static HashMap<Integer, Integer> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N]; // 원본 배열
		sorted = new int[N]; // 정렬을 위한 복사본 배열


		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sorted[i] = arr[i];
		}

		Arrays.sort(sorted); // -10 -9 2 4 4

		int rank = 0;
		for (int i = 0; i < sorted.length; i++) {
			if (map.containsKey(sorted[i])) {
				map.put(sorted[i], map.get(sorted[i]));
			} else {
				map.put(sorted[i], rank);
				rank++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}

		System.out.println(sb.toString());


	}

}

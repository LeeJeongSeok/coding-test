package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _18870_ {

	static int N;
	static int[] arr, temp;
	static HashMap<Integer, Integer> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		temp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			temp[i] = arr[i];
		}

		Arrays.sort(temp);

		int rank = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!map.containsKey(temp[i])) {
				map.put(temp[i], rank);
				rank++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}

		System.out.println(sb.toString());
	}

}

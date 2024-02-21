package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _11497_ {

	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] result = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int left = 0;
			int right = arr.length - 1;

			for (int i = 0; i < arr.length; i++) {
				if (i % 2 == 0) {
					result[left] = arr[i];
					left++;
				} else {
					result[right] = arr[i];
					right--;
				}
			}

			int min = Math.abs(result[0] - result[1]);

			for (int i = 1; i < result.length; i++) {
				min = Math.max(min, Math.abs(result[i] - result[i - 1]));
			}

			System.out.println(min);
		}

	}

}

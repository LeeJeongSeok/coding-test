package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _1026_ {

	static int N, S;
	static int[] A;
	static int[] B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < N; i++) {
			S += A[i] * B[N - i - 1];
		}

		System.out.println(S);
	}

}

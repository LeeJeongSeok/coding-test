package jeongseok.baekjoon;

/**
 * 2
 * 5 6
 * 0 0 1 0
 */
import java.io.*;
import java.util.*;

public class _14888_ {

	static int N;
	static int[] num;
	static int[] operator;
	static int[] temp;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		operator = new int[4];
		temp = new int[N - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}


		rec_func(0);

		System.out.println(max);
		System.out.println(min);
	}

	private static void rec_func(int depth) {
		if (depth == N - 1) {
			int result = calculate();

			min = Math.min(min, result);
			max = Math.max(max, result);

			return;
		}

		for (int i = 0; i < operator.length; i++) {
			if (operator[i] != 0) {
				operator[i]--;
				temp[depth] = i; // 인덱스로 사칙연산을 구분할 예정임
				rec_func(depth + 1);
				operator[i]++;
			}
		}
	}

	private static int calculate() {
		int sum = num[0];

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 0) {
				sum += num[i + 1];
			} else if (temp[i] == 1) {
				sum -= num[i + 1];
			} else if (temp[i] == 2) {
				sum *= num[i + 1];
			} else if (temp[i] == 3) {
				sum /= num[i + 1];
			}
		}

		return sum;

	}

}

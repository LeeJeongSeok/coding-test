package jeongseok.baekjoon;

// 5
// 1 2 3

import java.io.*;

public class _1789_ {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		long N = 0;

		for (int i = 1; ;i++) {
			if (sum > S) {
				break;
			}
			sum += i;
			N++;
		}


		System.out.println(N - 1);
	}

}

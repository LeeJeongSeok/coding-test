package jeongseok.baekjoon;

/**
 * 2024.02.19
 * 세 각의 크기가 모두 60이면, Equilateral
 * 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
 * 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
 * 세 각의 합이 180이 아닌 경우에는 Error
 *
 * 제한사항 : 3개 각 모두 0보다 크고 180보다 작다.
 */

import java.io.*;

public class _10101_2 {

	static int A, B, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());

		if (A == 60 && B == 60 && C == 60) {
			System.out.println("Equilateral");
		} else if (A + B + C == 180 && (A == B) || (A == C) || (B == C)) {
			System.out.println("Isosceles");
		} else if (A + B + C == 180) {
			System.out.println("Scalene");
		} else {
			System.out.println("Error");
		}

	}

}

package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _10101_ {

	static int x, y, z;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		x = Integer.parseInt(br.readLine());
		y = Integer.parseInt(br.readLine());
		z = Integer.parseInt(br.readLine());

		int total = x + y + z;

		if (x == 60 && y == 60 && z == 60) {
			System.out.println("Equilateral");
		} else if (total == 180 && isSame(x, y, z)) {
			System.out.println("Isosceles");
		} else if (total == 180 && !isSame(x, y, z)) {
			System.out.println("Scalene");
		} else {
			System.out.println("Error");
		}
	}

	private static boolean isSame(int x, int y, int z) {
		if (x == y || x == z || y == z) {
			return true;
		}
		return false;
	}
}

package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 각각의 스텝별로 문제가 뭔지를 파악하는 것이 키포인트같다,
 * 1. 전체 종이가 모두 같은 색으로 칠해져 있지 않으면 가로와 세로 부분을 자르는데, 이때ㅐ N/2 * N/2로 자른다,
 * 2. 나누어진 종이가 모두 같은 색으로 칠해져 있지 않으면 1번 과정을 반복한다.
 * 3. 모두 하얀색이거나 모두 파란색이고, 하나의 정사각형칸이 되어 더 이상 자를 수 없다면 합친다,
 */

public class _2630_2 {

	static int[][] arr;
	static int N, white, blue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rec_func(0, 0, N);

		System.out.println(white);
		System.out.println(blue);
	}

	private static void rec_func(int row, int col, int size) {

		// 전체 종이가 모두 같은색으로 칠해져 있다면
		if (isSame(row, col, size)) {
			if (arr[row][col] == 0) { // 전체 종이가 하얀색으로 칠해져 있는 경우
				white++;
			} else { // 전체 종이가 파란색으로 칠해져 있는 경우
				blue++;
			}
			return;
		}

		int newSize = size / 2;

		// 2사분면, 1사분면, 3사분면, 4사분면 순으로 탐색
		rec_func(row, col, newSize);
		rec_func(row, col + newSize, newSize);
		rec_func(row + newSize, col, newSize);
		rec_func(row + newSize, col + newSize, newSize);

	}

	private static boolean isSame(int row, int col, int size) {
		int current = arr[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (arr[i][j] != current) {
					return false;
				}
			}
		}

		return true;
	}

}

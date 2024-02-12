package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 분할 정복은 기본적으로 아래의 두가지 개념을 알고있어야 한다.
 * 1. 재귀에 대한 이해
 * 2. 탐색에 대한 이해
 *
 * 기본적으로, 분할 정복의 과정은 3단계로 나뉜다.
 * 1. 현재 상태의 문제를 풀 수 없는 경우 문제를 분할 할 수 있는지 확인
 * 2. 문제를 분할하여 각각 풀이한다. (풀이 할 수 없는 경우 1번 과정으로 간다.)
 * 3. 풀린 문제들을 합친다.
 *
 * 각각의 스텝별로 문제가 뭔지를 파악하는 것이 키포인트같다,
 * 1. 흑백 영상이 모두 같은 색으로 칠해져 있지 않으면 가로와 세로 부분을 자른다. 이때 N/2 * N/2로 자른다.
 * 2. 나누어진 영상이 모두 같은 색으로 이루어져 있지 않으면 1번 과정을 반복한다.
 * 3. 모두 하얀색이거나 모두 검은색이고, 하나의 정사각형칸이 되어 더 이상 자를 수 없다면 합친다,
 *
 * 여기서 각 스텝별로 문제를 더 작게 쪼개보자
 * 1-1. 모두 같은 색으로 칠해져 있는지를 어떻게 확인할 것인가?
 * 	N = 4일때를 생각해보자
 * 	1 1 0 0
 * 	1 1 0 0
 * 	0 0 0 0
 * 	0 0 0 0
 * 	첫번째 원소를 기준으로 2차원 배열 탐색을 실시하는데, 이때 첫번쨰 원소와 다르다면 바로 탈출
 * 	이때, 시작은 row = 0, col = 0 이면서 N까지 반복하면 된다.
 */

public class _1992_ {

	static int[][] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < split.length; j++) {
				arr[i][j] = Integer.parseInt(split[j]);
			}
		}

		quadTree(0, 0, N);
		System.out.println(sb.toString());
	}

	private static void quadTree(int row, int col, int size) {
		if (isCompress(row, col, size)) {
			sb.append(arr[row][col]);
			return;
		}

		int newSize = size / 2;

		sb.append("(");

		quadTree(row, col, newSize);
		quadTree(row, col + newSize, newSize);
		quadTree(row + newSize, col, newSize);
		quadTree(row + newSize, col + newSize, newSize);

		sb.append(")");
	}

	private static boolean isCompress(int row, int col, int size) {

		int color = arr[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (arr[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}

}

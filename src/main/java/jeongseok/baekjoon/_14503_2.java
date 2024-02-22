package jeongseok.baekjoon;

/**
 * 반시계 방향 90도
 * 0 북
 * 1 동
 * 2 남
 * 3 서
 */

import java.io.*;
import java.util.*;

public class _14503_2 {

	static int N, M, r, c, d, answer;
	static int[][] map;
	static int[] dx = new int[]{-1, 0, 1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 1; // 가장 처음 빈칸은 청소가 안되어있기 때문에 바로 청소처리한다.
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		robotMachine(r, c, d);
		System.out.println(answer);
	}

	private static void robotMachine(int r, int c, int d) {
		// 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
		map[r][c] = 2;

		// 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int nx = r + dx[d];
			int ny = c + dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) {
				continue;
			}

			answer++;
			robotMachine(nx, ny, d);
			return;
		}

		// 3. 빈 칸이 없는 경우
		int bd = (d + 2) % 4;
		int bx = r + dx[bd];
		int by = c + dy[bd];

		if (bx < 0 || bx >= N || by < 0 || by >= M || map[bx][by] == 1) {
			return;
		}

		robotMachine(bx, by, d);
	}
}

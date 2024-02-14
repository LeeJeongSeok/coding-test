package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _14503_ {

	static int N, M, r, c, d, answer;
	static int[][] map;
	// 북, 동, 남 서
	static int[] dx = new int[]{-1, 0, 1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = 1; // 처음에 빈 칸은 청소되지 않은 상태로 있기 때문에 먼저 1를 카운트해준다.

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

		dfs(r, c, d);
		System.out.println(answer);
	}

	private static void dfs(int curX, int curY, int direction) {
		map[curX][curY] = 2;

		for (int i = 0; i < 4; i++) {
			direction = (direction + 3) % 4;
			int nx = curX + dx[direction];
			int ny = curY + dy[direction];

			if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
				answer++;
				dfs(nx, ny, direction);
				return;
			}
		}

		int backD = (direction + 2) % 4;
		int backX = curX + dx[backD];
		int backY = curY + dy[backD];

		if (backX >= 0 && backX < N && backY >= 0 && backY < M && map[backX][backY] != 1) {
			dfs(backX, backY, direction);
		}
	}

}

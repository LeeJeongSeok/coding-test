package jeongseok.programmers.lv2;

import java.util.*;

class Position {
	int x;
	int y;
	int distance;

	public Position(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}

public class MazeEscape {

	int[] dx = new int[]{-1, 0, 1, 0};
	int[] dy = new int[]{0, 1, 0, -1};

	public int solution(String[] maps) {

		int[] start = findPosition('S', maps);
		int[] lever = findPosition('L', maps);

		int distanceToLever = bfs('L', start, maps);
		int distanceToExit = bfs('E', lever, maps);

		if (distanceToLever == 0) {
			return -1;
		}

		if (distanceToExit == 0) {
			return -1;
		}

		return distanceToLever + distanceToExit;
	}

	private int[] findPosition(char destination, String[] maps) {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				if (maps[i].charAt(j) == destination) {
					return new int[]{i, j};
				}
			}
		}

		return new int[]{};
	}

	private int bfs(char destination, int[] start, String[] maps) {
		Queue<Position> queue = new LinkedList<>();
		boolean[][] visited = new boolean[maps.length][maps[0].length()];

		queue.add(new Position(start[0], start[1], 0));
		visited[start[0]][start[1]] = true;

		int answer = 0;

		while (!queue.isEmpty()) {
			Position cur = queue.poll();

			if (maps[cur.x].charAt(cur.y) == destination) {
				answer = cur.distance;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length()) {
					continue;
				}

				if (maps[nx].charAt(ny) == 'X' || visited[nx][ny]) {
					continue;
				}

				queue.add(new Position(nx, ny, cur.distance + 1));
				visited[nx][ny] = true;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		new MazeEscape().solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"});
		new MazeEscape().solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"});
	}

}

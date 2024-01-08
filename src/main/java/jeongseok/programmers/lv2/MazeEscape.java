package jeongseok.programmers.lv2;

import java.util.*;

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class MazeEscape {

	int[] dx = new int[]{-1, 0, 1, 0};
	int[] dy = new int[]{0, 1, 0, -1};
	boolean[][] visited;

	Queue<Position> leverQueue = new LinkedList<>();
	Queue<Position> exitQueue = new LinkedList<>();

	Position start = null;
	Position exit = null;
	Position lever = null;

	public int solution(String[] maps) {
		int answer = 0;
		visited = new boolean[maps.length][maps[0].length()];

		for (int i = 0; i < maps.length; i++) {
			String[] split = maps[i].split("");
			for (int j = 0; j < split.length; j++) {
				if (maps[i].charAt(j) == 'S') {
					start = new Position(i, j);
				}

				if (maps[i].charAt(j) == 'E') {
					exit = new Position(i, j);
				}

				if (maps[i].charAt(j) == 'L') {
					lever = new Position(i, j);
				}
			}
		}

		leverQueue.add(start);
		visited[start.x][start.y] = true;
		int distanceToLever = findLever(maps);
		int distanceToExit = findExit(maps);

		answer = (distanceToLever == 0) ? -1 : answer + distanceToLever;
		answer = (distanceToExit == 0) ? -1 : answer + distanceToExit;

		return answer;
	}

	private int findLever(String[] maps) {
		int distance = 0;

		while (!leverQueue.isEmpty()) {
			Position cur = leverQueue.poll();

			if (maps[cur.x].charAt(cur.y) == 'L') {
				exitQueue.add(new Position(cur.x, cur.y));
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

				leverQueue.add(new Position(nx, ny));
				visited[nx][ny] = true;
				distance++;
			}
		}

		return distance;
	}

	private int findExit(String[] maps) {
		int distance = 0;

		while (!exitQueue.isEmpty()) {
			Position cur = exitQueue.poll();

			if (maps[cur.x].charAt(cur.y) == 'E') {
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

				exitQueue.add(new Position(nx, ny));
				visited[nx][ny] = true;
				distance++;
			}
		}

		return distance;
	}
	public static void main(String[] args) {
		new MazeEscape().solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"});
		new MazeEscape().solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"});
	}

}

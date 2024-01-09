package jeongseok.programmers.lv2;

import java.util.*;
import java.util.stream.*;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class DesertIslandTravel {

	int[] dx = new int[]{-1, 0, 1, 0};
	int[] dy = new int[]{0, 1, 0, -1};
	ArrayList<Integer> list = new ArrayList<>();
	boolean[][] visited;

	public int[] solution(String[] maps) {

		visited = new boolean[maps.length][maps[0].length()];

		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				if (maps[i].charAt(j) != 'X' && !visited[i][j]) { // 방문하지 않은 무인도
					list.add(bfs(i, j, maps));
				}
			}
		}

		if (!list.isEmpty()) {
			// 오름차순 정리
			Collections.sort(list);
			return list.stream().mapToInt(Integer::intValue).toArray();
		} else {
			return new int[]{-1};
		}
	}

	private int bfs(int x, int y, String[] maps) {
		int answer = 0;

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			answer += Character.getNumericValue(maps[cur.x].charAt(cur.y));

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length()) {
					continue;
				}

				if (maps[nx].charAt(ny) == 'X' || visited[nx][ny]) {
					continue;
				}

				queue.add(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		new DesertIslandTravel().solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"});
		new DesertIslandTravel().solution(new String[]{"XXX","XXX","XXX"});
	}

}

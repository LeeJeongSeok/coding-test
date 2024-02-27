package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

class Road {
	int start;
	int end;
	int shortcut;

	public Road(int start, int end, int shortcut) {
		this.start = start;
		this.end = end;
		this.shortcut = shortcut;
	}
}

public class _1446_ {
	static int N, D;
	static ArrayList<Road> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();

		// 노드 전체가 다 들어가는 형태는 아님 (입력 시작)
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int shortcut = Integer.parseInt(st.nextToken());

			// 역주행 불가 (각 노드의 도착지점이 최종목적지인 D보다 크다면 역주행이기 떄문에 불가능)
			if (end > D) {
				continue;
			}

			// 지름길이 아닌 경우 (각 노드의 도착지점과 출발지점을 뺏을때, 지름길의 도착지점보다 작다면 지름길이 아니다)
			// 이 경우에 대한 이해 필요
			if (end - start <= shortcut) {
				continue;
			}

			list.add(new Road(start, end, shortcut));

		} // (입력 종료)

		// 정렬
		list.sort((o1, o2) -> {
			if (o1.start == o2.start) {
				return o1.end - o2.end;
			}

			return o1.start - o2.start;
		});

		int idx = 0;
		int move = 0;
		int[] dist = new int[10001];
		Arrays.fill(dist, 10001);
		dist[0] = 0;

		// 다익스트라
		while (move < D) {
			if (idx < list.size()) {
				Road road = list.get(idx);
				if (move == road.start) {
					dist[road.end] = Math.min(dist[move] + road.shortcut, dist[road.end]);
					idx++;
				} else {
					dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
					move++;
				}
			} else {
				dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
				move++;
			}
		}

		System.out.println(dist[D]);
	}

}

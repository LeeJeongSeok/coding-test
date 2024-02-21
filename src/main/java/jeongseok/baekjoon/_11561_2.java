package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

class Coordination2 {
	int x;
	int y;

	public Coordination2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class _11561_2 {

	static int N;
	static ArrayList<Coordination2> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Coordination2(x, y));
		}

		list.sort((o1, o2) -> {
			if (o1.y == o2.y) {
				return o1.x - o2.x;
			}
			return o1.y - o2.y;
		});

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).x).append(" ").append(list.get(i).y).append("\n");
		}

		System.out.println(sb.toString());

	}

}

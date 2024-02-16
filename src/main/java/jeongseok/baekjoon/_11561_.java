package jeongseok.baekjoon;

import java.util.*;
import java.io.*;

class Coordination {

	int x;
	int y;

	public Coordination(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class _11561_ {

	static int N;
	static ArrayList<Coordination> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Coordination(x, y));
		}

		list.sort((o1, o2) -> {
			if (o1.y == o2.y) {
				return o1.x - o2.x;
			}
			return o1.y - o2.y;
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).x + " " + list.get(i).y);
		}
	}
}

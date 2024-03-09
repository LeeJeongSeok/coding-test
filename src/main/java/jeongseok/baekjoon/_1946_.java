package jeongseok.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Candidate implements Comparable<Candidate> {
	int document;
	int interview;

	public Candidate(int document, int interview) {
		this.document = document;
		this.interview = interview;
	}

	@Override
	public int compareTo(Candidate o) {
		return this.document - o.document;
	}
}

public class _1946_ {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Candidate> list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int document = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				list.add(new Candidate(document, interview));
			}

			Collections.sort(list);

			int answer = 1; // 서류 1등은 무조건 통과
			int min = list.get(0).interview; // 서류 1등의 면접 등수

			for (int i = 1; i < list.size(); i++) { // 서류 2등부터 비교시작
				if (list.get(i).interview < min) { // 2등의 면접 등수가 1등보다 낮다면, 즉 2등의 면접 접수가 3위 이고 1등의 면접접수가 4위이면 2등은 1등보다 면접을 잘봤기 때문에 통과
					answer++;
					min = list.get(i).interview;
				}
			}

			System.out.println(answer);
		}
	}

}

package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _1946_2 {

	static int T;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<int[]> list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int[] arr = new int[2];
				arr[0] = Integer.parseInt(st.nextToken());
				arr[1] = Integer.parseInt(st.nextToken());

				list.add(arr);
			}

			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});

			int[] first = list.get(0);
			int answer = 1; // 서류점수 순으로 오름차순 정렬했을 때, 가장 맨 위에 있는 지원자는 무조건 합격이기 때문에 1부터 시작
			int interviewMin = first[1];

			for (int i = 1; i < list.size(); i++) {
				int[] candidate = list.get(i);
				if (candidate[1] < interviewMin) {
					answer++;
					interviewMin = candidate[1];
				}
			}

			System.out.println(answer);

		}
	}
}

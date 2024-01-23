package jeongseok.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MaxCounters {

	public int[] solution(int N, int[] A) {
		// Implement your solution here
		int[] answer = new int[N];
		int max = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();

		// 맵 초기화
		for (int i = 1; i <= N; i++) {
			map.put(i, 0);
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] > N) {
				int finalMax = max;
				map.replaceAll((k, v) -> finalMax);
			} else {
				map.put(A[i], map.get(A[i]) + 1);
				max = Math.max(max, map.get(A[i]));
			}
		}

		for (Integer i : map.keySet()) {
			answer[i - 1] = map.get(i);
		}



		return answer;
	}

	public static void main(String[] args) {
		new MaxCounters().solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
		new MaxCounters().solution(1, new int[]{2, 1, 1, 2, 1});
//		new MaxCounters().solution(100000, new int[]{100001, 100001, 100001, 100001, 100001});

	}

}

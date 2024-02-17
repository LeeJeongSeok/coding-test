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
		int temp_max = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] > N) {
				max = temp_max;
			} else {
				// 배열의 인덱스가 0부터 시작하기 때문이다. 만약 이렇게 작성하기 싫다면 정답 배열의 사이즈를 N + 1로 해줘야함
				int count = A[i] - 1;
				if (answer[count] < max) {
					answer[count] = max;
				}
				answer[count]++;
				temp_max = Math.max(temp_max, answer[count]);
			}
		}

		for (int i = 0; i < answer.length; i++) {
			if (answer[i] < max) {
				answer[i] = max;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		new MaxCounters().solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
		new MaxCounters().solution(1, new int[]{2, 1, 1, 2, 1});
//		new MaxCounters().solution(100000, new int[]{100001, 100001, 100001, 100001, 100001});

	}

}

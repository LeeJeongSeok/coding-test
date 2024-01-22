package jeongseok.programmers.lv2;

import java.util.Arrays;

public class SeesawFriend {

	public long solution(int[] weights) {
		long answer = 0;
		int count = 0;

		Arrays.sort(weights);

		for (int i = 0; i < weights.length - 1; i++) {
			if (i > 0 && weights[i] == weights[i - 1]) {
				count--;
				answer += count;
				continue;
			}

			int index = binarySearch(weights, weights[i], i + 1);

			count = 0;
			for (int j = index; j > i; j--) {
				if (weights[i] == weights[j] || weights[i] * 2 == weights[j] || weights[i] * 3 == weights[j] * 2 || weights[i] * 4 == weights[j] * 3) {
					count++;
				}
			}

			answer += count;
		}
		return answer;
	}

	private int binarySearch(int[] weights, int number, int i) {
		int start = i;
		int end = weights.length - 1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (weights[mid] > number * 2) {
				return mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

	public static void main(String[] args) {
		new SeesawFriend().solution(new int[]{100, 180, 360, 100, 270});
	}

}

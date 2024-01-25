package jeongseok.leetcode;

public class PassingCars {

	public int solution(int[] A) {
		// Implement your solution here
		int answer = 0;
		int count = 0;
		int j = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1 && i < A.length - 1) {
				continue;
			}
			if (A[i] == 0 || i == A.length - 1) {
				answer += count;
				count = 0;

				j = i;
			}

			while (j < A.length) {
				if (A[j] == 0) {
					j++;
				} else {
					count++;
					j++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		new PassingCars().solution(new int[]{0, 1, 0, 1, 1});
	}

}

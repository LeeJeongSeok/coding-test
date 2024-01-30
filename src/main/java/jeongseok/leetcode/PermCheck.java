package jeongseok.leetcode;

public class PermCheck {

	public int solution(int[] A) {

		int max = getMaxValue(A);

		int[] answer = new int[max + 1];

		for (int i = 0; i < A.length; i++) {
			answer[A[i]] = 1;
		}

		for (int i = 1; i < answer.length; i++) {
			if (answer[i] == 0) {
				return 0;
			}
		}

		return 1;
	}

	private int getMaxValue(int[] arr) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(new PermCheck().solution(new int[]{4, 1, 3, 2}));
		System.out.println(new PermCheck().solution(new int[]{4, 1, 3}));

	}

}

package jeongseok.leetcode;

import java.util.HashSet;

public class FrogRiverOne_2 {

	public int solution(int X, int[] A) {
		// Implement your solution here
		int[] arr = new int[X + 1];

		for (int i = 0; i < A.length; i++) {
			arr[A[i]] = A[i];

			//
		}

		return -1;
	}

	private int checkArr(int[] arr, int X) {
		for (int i = 1; i <= X; i++) {
			if (arr[i] == 0) {
				return -1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		new FrogRiverOne_2().solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
	}

}

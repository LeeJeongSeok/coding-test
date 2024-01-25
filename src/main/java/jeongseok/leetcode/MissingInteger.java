package jeongseok.leetcode;

public class MissingInteger {

	public int solution(int[] A) {
		// Implement your solution here
		int[] arr = new int[A.length * 2 + 1];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			if (A[i] < 0) {
				arr[i] = Math.abs(A[i]);
			} else {
				arr[A.length + A[i]] = A[i];
			}
		}

		int start = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				start = i;
				break;
			}
		}

		for (int i = start; i < arr.length; i++) {
			if (arr[i] != 0 && i < arr.length / 2) {
				max = arr[i];
				if (max < arr.length / 2) {
					return 1;
				}
			} else if (arr[i] == 0) {
				return arr[i - 1] + 1;
			}
		}

		return A.length + 1;
	}

	public static void main(String[] args) {
//		System.out.println(new Missing().solution(new int[]{1, 3, 6, 4, 1, 2}));
//		System.out.println(new Missing().solution(new int[]{1, 2, 3}));
		System.out.println(new MissingInteger().solution(new int[]{-1, -3}));
		System.out.println(new MissingInteger().solution(new int[]{-2, -3, 1, 3, 2, 5, 6}));
	}

}

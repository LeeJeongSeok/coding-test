package jeongseok.leetcode;

public class PermCheck {

	// 1 ~ N까지의 수열이 전부다 있다고 가정할 떄의 합과, A의 모든 원소의 합을 구했을 때, 서로 값이 다르다면 A는 수열이 아니다.
	public int solution(int[] A) {

		int max = getMaxValue(A);
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 1; i <= max; i++) {
			sum1 += i;
		}

		for (int i = 0; i < A.length; i++) {
			sum2 += A[i];
		}

		if (sum1 == sum2) {
			return 1;
		}

		return 0;
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

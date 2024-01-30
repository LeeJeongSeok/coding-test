package jeongseok.leetcode;

import java.util.Arrays;

public class PermCheck {

	// 1 ~ N까지의 수열이 전부다 있다고 가정할 떄의 합과, A의 모든 원소의 합을 구했을 때, 서로 값이 다르다면 A는 수열이 아니다. (실패)
	// 배열 A를 정렬 후 1부터 비교
	public int solution(int[] A) {

		Arrays.sort(A);

		// 여기서 i의 초기값이 1부터 시작하게 된다고 가정하고, 배열의 원소가 1개인 경우에는 for문 자체를 탐색하지 않아서 수열로 간주된다.
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return 0;
			}
		}

		return 1;
	}

	public static void main(String[] args) {
//		System.out.println(new PermCheck().solution(new int[]{4, 1, 3, 2}));
//		System.out.println(new PermCheck().solution(new int[]{4, 1, 3}));
		System.out.println(new PermCheck().solution(new int[]{2}));

	}

}

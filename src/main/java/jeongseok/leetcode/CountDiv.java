package jeongseok.leetcode;

/**
 * 3개의 정수 A, B, K가 주어졌을 때
 * A ~ B 범위내에서 K로 나눠지는 수들을 카운팅하는 문제
 */

public class CountDiv {

	public int solution(int A, int B, int K) {
		// Implement your solution here
		int count = 0;
		int sum = A;

		while (sum < B) {
			sum += K;
			count++;
		}

		return count;
	}

	public static void main(String[] args) {
		new CountDiv().solution(6, 11, 2);
		new CountDiv().solution(6, 6, 8);
//		new CountDiv().solution(0, 2_000_000_000, 2_000_000_000); // 예를 그냥 돌려버리면 20억번 돈다. -> 시간초과
	}

}

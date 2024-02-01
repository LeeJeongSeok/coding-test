package jeongseok.leetcode;

public class PassingCars {

	//https://app.codility.com/demo/results/trainingQ29Y8W-3SJ/ 0보다 작을 떄 고려해야함,,,
	public int solution(int[] A) {
		// Implement your solution here
		int answer = 0;
		int count = 0;

		for (int i = 0; i < A.length; i++) {
			count += A[i];
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				answer += count;
			} else {
				count--;
			}
		}

		// 최악의 경우 음수가 들어오는 경우도 포함되어 있기 때문에 0보다 작은 경우도 포함시켜줘야 한다.
		if (answer > 1_000_000_000 || answer < 0) {
			return -1;
		}

		return answer;
	}

	public static void main(String[] args) {
		new PassingCars().solution(new int[]{0, 1, 0, 1, 1});
	}

}

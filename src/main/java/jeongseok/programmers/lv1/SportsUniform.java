package jeongseok.programmers.lv1;

public class SportsUniform {

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}

		for (int i = 0; i < reserve.length; i++) {
			arr[reserve[i] - 1] = 2;
		}

		for (int i = 0; i < lost.length; i++) {
			if (arr[lost[i] - 1] == 2) {
				arr[lost[i] - 1]--;
			} else {
				arr[lost[i] - 1] = 0;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				// 첫번째 학생이 도난당한 경우에는 앞에 학생한태 빌릴 수 없기 때문에 뒷 학생한테 빌린다.
				if (i == 0) {
					if (arr[i + 1] == 2) {
						arr[i] = 1;
						arr[i + 1] = 1;
					}
					continue;
				}

				if (i == n - 1) {
					if (arr[i - 1] == 2) {
						arr[i] = 1;
						arr[i - 1] = 1;
					}
					continue;
				}

				int front = arr[i - 1];
				int back = arr[i + 1];

				if (front == 2) {
					arr[i] = 1;
					arr[i - 1] = 1;
				} else if (back == 2) {
					arr[i] = 1;
					arr[i + 1] = 1;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
//		new SportsUniform().solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
//		new SportsUniform().solution(5, new int[]{2, 4}, new int[]{3});
//		new SportsUniform().solution(3, new int[]{3}, new int[]{1});
//		new SportsUniform().solution(5, new int[]{3, 5}, new int[]{2, 4});
		new SportsUniform().solution(3, new int[]{3}, new int[]{1});
	}

}

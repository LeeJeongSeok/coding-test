package jeongseok.programmers.lv2;

public class MagicElevator {

	public int solution(int storey) {
		int answer = 0;

		int[] arr = new int[String.valueOf(storey).length()];

		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = storey % 10;
			storey /= 10;
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] < 5) {
				while (arr[i] % 10 != 0) {
					answer++;
					arr[i]--;
				}
			} else {
				while (arr[i] % 10 != 0) {
					answer++;
					arr[i]++;
				}
				arr[i - 1]++;
				arr[i] = 0;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		new MagicElevator().solution(16);
		new MagicElevator().solution(2554);
	}

}

package jeongseok.programmers.lv2;

public class MagicElevator {

	public int solution(int storey) {
		int answer = 0;

		while (storey > 0) {
			int number = storey % 10;
			storey /= 10;

			if (number < 5) {
				answer += number;
			} else if (number > 5) {
				answer += 10 - number;
				storey++;
			} else {
				answer += 5;
				if (storey % 10 >= 5) {
					storey++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		new MagicElevator().solution(16);
		new MagicElevator().solution(2554);
	}

}

package jeongseok.programmers.lv2;

import java.util.Arrays;
import java.util.Stack;

public class FindGreaterNumberBehind_2 {

	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Stack<Integer> stack = new Stack<>();

		Arrays.fill(answer, -1);
		stack.push(numbers[0]);

		for (int i = 1; i < numbers.length; i++) {
			if (stack.peek() < numbers[i]) {
				int dist = 0;
				while (!stack.isEmpty() && stack.peek() < numbers[i]) {
					dist++;

					if (answer[i - dist] != -1) {
						continue;
					}
					stack.pop();
					answer[i - dist] = numbers[i];

				}
				stack.push(numbers[i]);
			} else {
				stack.push(numbers[i]);
			}
		}

		return answer;
	}
	public static void main(String[] args) {
//		new FindGreaterNumberBehind_2().solution(new int[]{2, 3, 3, 5});
		new FindGreaterNumberBehind_2().solution(new int[]{8, 1, 2, 9});
	}

}

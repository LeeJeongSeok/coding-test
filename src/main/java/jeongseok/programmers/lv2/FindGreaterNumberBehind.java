package jeongseok.programmers.lv2;

import java.util.*;

public class FindGreaterNumberBehind {

	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Stack<Integer> stack = new Stack<>();

		Arrays.fill(answer, -1);
		stack.push(numbers[0]);

		for (int i = 1; i < numbers.length; i++) {
			// 바로 뒤 큰 수인 경우
			if (stack.peek() < numbers[i]) {
				int count = 0; // 큰 수가 얼만큼 떨어져 있는지를 체크함
				while (!stack.isEmpty() && stack.peek() < numbers[i]) {
					count++;
					// 만약에 이미 한번 방문한 곳이면?
					if (answer[i - count] != -1) {
						continue;
					}
					stack.pop();
					answer[i - count] = numbers[i];
				}
				stack.push(numbers[i]);
			} else {
				stack.push(numbers[i]);
			}
		}

		return answer;
	}
	public static void main(String[] args) {
		new FindGreaterNumberBehind().solution(new int[]{2, 3, 3, 5});
		new FindGreaterNumberBehind().solution(new int[]{9, 1, 5, 3, 6, 2});
		new FindGreaterNumberBehind().solution(new int[]{8, 1, 2, 9});
	}

}

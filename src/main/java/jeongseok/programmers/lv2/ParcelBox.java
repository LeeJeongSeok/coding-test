package jeongseok.programmers.lv2;

import java.util.*;

public class ParcelBox {

	public int solution(int[] order) {
		int answer = 0;
		int index = 0;
		int currentBox = 1;

		Stack<Integer> stack = new Stack<>();

		while (index < order.length) {
			if (order[index] > currentBox) {
				stack.push(currentBox);
				currentBox++;
			} else if (order[index] == currentBox) {
				answer++;
				index++;
				currentBox++;
			} else {
				while (!stack.isEmpty() && order[index] == stack.peek()) {
					stack.pop();
					answer++;
					index++;
				}
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		new ParcelBox().solution(new int[]{4, 3, 1, 2, 5});
		new ParcelBox().solution(new int[]{5, 4, 3, 2, 1});
	}

}

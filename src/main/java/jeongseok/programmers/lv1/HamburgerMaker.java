package jeongseok.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 프로그래머스 레벨1 - 햄버거 만들기
 *
 * 1차시도 - for문 실패
 * 2차시도 - stack
 *
 * 2, 1, 1, 2, 3, 1, 2, 3, 1
 */

public class HamburgerMaker {

	public int solution(int[] ingredient) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < ingredient.length; i++) {
			stack.push(ingredient[i]);

			if (stack.size() >= 4) {
				if (stack.get(stack.size() - 4) == 1 && stack.get(stack.size() - 3) == 2 && stack.get(stack.size() - 2) == 3 && stack.get(stack.size() - 1) == 1) {
					answer++;

					stack.pop();
					stack.pop();
					stack.pop();
					stack.pop();
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new HamburgerMaker().solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
		System.out.println(new HamburgerMaker().solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
	}

}

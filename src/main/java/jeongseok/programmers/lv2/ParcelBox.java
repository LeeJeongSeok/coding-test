package jeongseok.programmers.lv2;

import java.util.*;

public class ParcelBox {

	public int solution(int[] order) {
		int answer = 0;

		int[] arr = new int[order.length];
		Stack<Integer> main = new Stack<>();
		Stack<Integer> sub = new Stack<>();

		for (int i = 1; i <= order.length; i++) {
			arr[i - 1] = i;
		}

		// 컨테이너 벨트는 1번부터 상자를 내릴 수 있기 때문에 stack에 역순으로 저장
		for (int i = order.length - 1; i >= 0; i--) {
			main.push(arr[i]);
		}

		int index = 0;
		while (!main.isEmpty()) {
			if (main.peek() != order[index]) {
				sub.push(main.pop());
			} else {
				main.pop();
				answer++;
				index++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		new ParcelBox().solution(new int[]{4, 5, 1, 2, 3});
		new ParcelBox().solution(new int[]{5, 4, 3, 2, 1});
	}

}

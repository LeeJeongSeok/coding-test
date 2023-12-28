package jeongseok.programmers.lv1;

import java.util.*;

public class CraneDollGrabbingGame {

	static Stack<Integer> stack = new Stack<>();
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i] - 1] != 0) {
					answer += addDoll(board[j][moves[i] - 1]);
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
		}

		return answer;
	}

	private static int addDoll(int number) {
		int count = 0;

		if (stack.isEmpty()) {
			stack.push(number);
		} else if (stack.peek() == number) {
			stack.pop();
			count += 2;
		} else {
			stack.push(number);
		}

		return count;
	}

	public static void main(String[] args) {
		new CraneDollGrabbingGame().solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4});
	}

}

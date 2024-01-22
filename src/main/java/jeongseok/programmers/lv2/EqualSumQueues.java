package jeongseok.programmers.lv2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class EqualSumQueues {

	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;

		Queue<Long> first = new LinkedList<>();
		Queue<Long> second = new LinkedList<>();

		for (int i = 0; i < queue1.length; i++) {
			first.add((long) queue1[i]);
		}

		for (int i = 0; i < queue2.length; i++) {
			second.add((long) queue2[i]);
		}

		long firstTotal = getTotal(first);
		long secondTotal = getTotal(second);
		long total = firstTotal + secondTotal;
		long target = total / 2;

		while (true) {
			// 두 큐의 합이 동일할 경우
			if (firstTotal == target && secondTotal == target) {
				break;
			}

			// 두 큐 중 하나라도 비는 경우
			if (first.isEmpty() || second.isEmpty()) {
				return -1;
			}

			if (firstTotal < secondTotal) {
				first.add(second.poll());
			} else {
				second.add(first.poll());
			}
			answer++;

			firstTotal = getTotal(first);
			secondTotal = getTotal(second);
		}

		return answer;
	}

	private long getTotal(Queue<Long> queue) {
		long total = 0;

		Iterator<Long> iterator = queue.iterator();
		while (iterator.hasNext()) {
			total += iterator.next();
		}

		return total;
	}

	public static void main(String[] args) {
//		new EqualSumQueues().solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
//		new EqualSumQueues().solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
		new EqualSumQueues().solution(new int[]{1, 1}, new int[]{1, 5});
	}

}

package jeongseok.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class EqualSumQueues {

	public int solution(int[] queue1, int[] queue2) {
		int answer = -1;

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		long sum1 = 0;
		long sum2 = 0;

		for (int i : queue1) {
			q1.add(i);
			sum1 += i;
		}

		for (int i : queue2) {
			q2.add(i);
			sum2 += i;
		}

		int count = 0;
		while (count <= queue1.length * 4) {
			if (sum1 < sum2) {
				int poll = q2.poll();
				sum2 -= poll;
				sum1 += poll;
				q1.add(poll);
			} else if (sum1 > sum2){
				int poll = q1.poll();
				sum1 -= poll;
				sum2 += poll;
				q2.add(poll);
			} else if (sum1 == sum2){
				answer = count;
				break;
			}
			count++;
		}
		return answer;
	}

	public static void main(String[] args) {
		new EqualSumQueues().solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
		new EqualSumQueues().solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
		new EqualSumQueues().solution(new int[]{1, 1}, new int[]{1, 5});
	}

}

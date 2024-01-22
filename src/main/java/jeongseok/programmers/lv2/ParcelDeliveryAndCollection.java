package jeongseok.programmers.lv2;

import java.util.Stack;

public class ParcelDeliveryAndCollection {

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		Stack<int[]> delivery = new Stack<>();
		Stack<int[]> pickup = new Stack<>();

		for (int i = 0; i < n; i++) {
			delivery.add(new int[]{i + 1, deliveries[i]});
			pickup.add(new int[]{i + 1, pickups[i]});
		}

		while (!delivery.isEmpty() && !pickup.isEmpty()) {
			int[] d = delivery.peek();
			int[] p = pickup.peek();

			//배달 택배와, 수거 택배 중 더 먼 곳인 집을 하나 가져온다.
			if (d[1] > p[1]) {
				answer += d[0] * 2;
			} else {
				answer += p[0] * 2;
			}


			int temp = cap;
			while (!delivery.isEmpty() || temp == 0) {
				temp -= d[1];
				delivery.pop();
			}

			if (temp + p[1] < cap) {
				temp += p[1];
				pickup.pop();
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		new ParcelDeliveryAndCollection().solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
	}

}

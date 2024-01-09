package jeongseok.programmers.lv2;

import java.util.*;

public class HotelDayUse {
	public int solution(String[][] book_time) {

		int[][] bookTime = new int[book_time.length][2];

		// 분으로 시간변경 후 int[][] 배열에 저장
		for (int i = 0; i < book_time.length; i++) {
			String[] start = book_time[i][0].split(":");
			int startTime = convertToMinute(start[0], start[1]);

			String[] end = book_time[i][1].split(":");
			int endTime = convertToMinute(end[0], end[1]);
			endTime += 10;

			bookTime[i][0] = startTime;
			bookTime[i][1] = endTime;
		}

		// 입실시간이 빠른순으로 정렬
		Arrays.sort(bookTime, (a, b) -> a[0] - b[0]);

		// 퇴실시간만을 저장하는 우선순위 큐
		// TODO : 아직 처리되는 방법을 모르겠음,,
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int[] time : bookTime) {
			if (queue.isEmpty()) {
				queue.add(time[1]);
				continue;
			}

			if (time[0] >= queue.peek()) {
				queue.poll();
				queue.add(time[1]);
			} else {
				queue.add(time[1]);
			}
		}

		return queue.size();
	}

	private int convertToMinute(String hour, String minute) {
		return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
	}

	public static void main(String[] args) {
		new HotelDayUse().solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}});
	}

}

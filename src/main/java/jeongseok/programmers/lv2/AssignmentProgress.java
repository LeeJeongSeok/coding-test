package jeongseok.programmers.lv2;

import java.util.*;

class Report {

	String name;
	int start;
	int playtime;

	public Report(String name, String start, String playtime) {
		this.name = name;
		this.start = convertToMinute(start);
		this.playtime = Integer.parseInt(playtime);
	}

	private int convertToMinute(String start) {
		String[] split = start.split(":");
		int hour = Integer.parseInt(split[0]);
		int minute = Integer.parseInt(split[1]);

		return hour * 60 + minute;
	}
}

public class AssignmentProgress {
	PriorityQueue<Report> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
	Stack<Report> stack = new Stack<>();
	ArrayList<String> result = new ArrayList<>();
	int currentTime = 0;

	public String[] solution(String[][] plans) {

		for (String[] plan : plans) {
			pq.add(new Report(plan[0], plan[1], plan[2]));
		}

		currentTime = pq.peek().start;

		while (!pq.isEmpty()) {
			Report cur = pq.poll();
			Report next = pq.peek();

			// 마지막 과제인경우
			if (next == null) {
				result.add(cur.name);
				break;
			}

			// 현재시간과 현재 시작해야하는 과제의 종료시간이 그 다음 과제의 시작시간과 동일한 경우 완료처리 후, 현재 시간을 다음 과제 시작시간으로 갱신
			if (currentTime + cur.playtime == next.start) {
				result.add(cur.name);
				currentTime = next.start;
			} else if (currentTime + cur.playtime < next.start) { // 현재시간과 현재 시작해야하는 과제의 종료시간이 그 다음 과제의 시작시간보다 일찍 끝나는 경우 일단 현재 과제는 완료처리한다.
				result.add(cur.name);

				// 남아 있는 과제가 없는 경우
				if (stack.isEmpty()) {
					currentTime = next.start;
					break;
				} else {
					currentTime += cur.playtime;
				}

				while(!stack.isEmpty() && currentTime != next.start){  // 공백 시간내에 여러 remainWork 를 할 수 있음
					Report remind = stack.pop();

					if(currentTime + remind.playtime <= next.start){  // 공백 시간내에 remainWork 를 끝낸 경우
						result.add(remind.name);
						currentTime += remind.playtime;
					}else{                                                  // 공백 시간내에 remainWork 를 끝내지 못한 경우
						remind.playtime -= next.start - currentTime;
						currentTime += remind.playtime;
						stack.push(remind);
					}
				}
			} else {
				cur.playtime -= next.start - currentTime;
				currentTime = next.start;
				stack.push(cur);
			}
		}

		// 중간에 멈춘 과제들을 마저 진행한다.
		while (!stack.isEmpty()) {
			Report cur = stack.pop();
			result.add(cur.name);
		}

		return result.stream().toArray(String[]::new);
	}

	public static void main(String[] args) {
//		new AssignmentProgress().solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
//		new AssignmentProgress().solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
		new AssignmentProgress().solution(new String[][]{{"A", "11:50", "30"}, {"B", "13:00", "20"}, {"C", "13:10", "30"}});
	}
}

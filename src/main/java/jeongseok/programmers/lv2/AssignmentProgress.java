package jeongseok.programmers.lv2;

import java.util.*;

class Report implements Comparable<Report> {

	String name;
	String start;
	String playtime;

	public Report(String name, String start, String playtime) {
		this.name = name;
		this.start = start;
		this.playtime = playtime;
	}

	@Override
	public int compareTo(Report report) {
		return this.start.compareTo(report.start);
	}
}

public class AssignmentProgress {
	PriorityQueue<Report> pq = new PriorityQueue<>();
	Stack<Report> stack = new Stack<>();
	ArrayList<String> result = new ArrayList<>();

	public String[] solution(String[][] plans) {

		for (String[] plan : plans) {
			pq.add(new Report(plan[0], plan[1], plan[2]));
		}

		// 시작
		// pq에 가장 맨 앞에 있는 과제를 뽑는다.
		// 바로 뒤에 있는 과제와 시간비교를 했을 때 종료가 불가능하다면 스택으로 저장
		while (!pq.isEmpty()) {
			Report cur = pq.poll();

			String finishedTime = calculateFinishedTime(cur.start, cur.playtime);

			if (!pq.isEmpty()) {
				Report next = pq.peek();

				if (finishedTime.compareTo(next.start) > 0) {
					stack.push(cur);
					continue;
				}
			}
			result.add(cur.name);
		}

		// 중간에 멈춘 과제들을 마저 진행한다.
		while (!stack.isEmpty()) {
			Report cur = stack.pop();
			result.add(cur.name);
		}

		return result.stream().toArray(String[]::new);
	}

	private static String calculateFinishedTime(String start, String playtime) {
		// ":"을 기준으로 시간과 분 분리
		String[] parts = start.split(":");
		int hours = Integer.parseInt(parts[0]);
		int minutes = Integer.parseInt(parts[1]);

		// 분을 더한 후 시간 계산
		int totalMinutes = hours * 60 + minutes + Integer.parseInt(playtime);
		int newHours = totalMinutes / 60;
		int newMinutes = totalMinutes % 60;

		// 24시간 형식으로 변환
		newHours %= 24;

		// 결과 출력
		return String.format("%02d:%02d", newHours, newMinutes);
	}

	public static void main(String[] args) {
		new AssignmentProgress().solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
		new AssignmentProgress().solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
	}
}

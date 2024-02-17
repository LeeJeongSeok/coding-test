package jeongseok.programmers.lv2;

import java.util.*;
import java.util.stream.*;

class Homework {
	String name;
	int start;
	int playtime;
	int remind;

	public Homework(String name, String start, String playtime) {
		this.name = name;
		this.start = convertToMinute(start);
		this.playtime = Integer.parseInt(playtime);
		this.remind = this.playtime;
	}

	public int convertToMinute(String start) {
		String[] split = start.split(":");
		int hour = Integer.parseInt(split[0]);
		int minute = Integer.parseInt(split[1]);
		return hour * 60 + minute;
	}
}

public class AssignmentProgress2 {

	public String[] solution(String[][] plans) {

		// 시작시간순으로 정렬해야함
		ArrayList<Homework> list = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		Stack<Homework> stack = new Stack<>();


		for (int i = 0; i < plans.length; i++) {
			list.add(new Homework(plans[i][0], plans[i][1], plans[i][2]));
		}

		list.sort((o1, o2) -> o1.start - o2.start);

		int currentTime = list.get(0).start;

		for (int i = 0; i < list.size(); i++) {
			Homework current = list.get(i);
			Homework next = null;
			if (i != list.size() - 1) {
				next = list.get(i + 1);
			}

			// 마지막 과제인경우
			if (next == null) {
				result.add(current.name);
				currentTime = current.start + current.playtime;

				if (!stack.isEmpty()) {
					Homework remindHomework = stack.pop();

					result.add(remindHomework.name);
				}
				continue;
			}

			if (current.start + current.playtime < next.start) {
				current.remind = next.start - current.playtime;
				stack.push(current);
				currentTime = next.start;
				continue;
			}

			if (current.start + current.playtime == next.start) {
				result.add(current.name);
				currentTime = next.start;
			}


		}

		return result.toArray(String[]::new);

	}

	public static void main(String[] args) {
//		new AssignmentProgress2().solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
		new AssignmentProgress2().solution(new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}});
	}

}

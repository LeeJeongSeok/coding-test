package jeongseok.programmers.lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class ReportResultReceiver_2 {

	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		HashMap<String, Integer> reportCount = new HashMap<>();
		HashMap<String, ArrayList<String>> reportBoard = new HashMap<String, ArrayList<String>>();

		for (int i = 0; i < id_list.length; i++) {
			reportCount.put(id_list[i], 0);
			reportBoard.put(id_list[i], new ArrayList<>());
		}

		for (int i = 0; i < report.length; i++) {
			String[] split = report[i].split(" ");
			String reportUser = split[0];
			String reportedUser = split[1];

			ArrayList<String> list = reportBoard.get(reportUser);
			if (!list.contains(reportedUser)) {
				list.add(reportedUser);
				reportCount.put(reportedUser, reportCount.get(reportedUser) + 1);
			}
		}

		for (int i = 0; i < id_list.length; i++) {
			int count = 0;
			ArrayList<String> list = reportBoard.get(id_list[i]);
			for (int j = 0; j < list.size(); j++) {
				if (reportCount.get(list.get(j)) >= k) {
					count++;
				}
			}
			answer[i] = count;
		}

		return answer;
	}

	public static void main(String[] args) {
		new ReportResultReceiver_2().solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
		new ReportResultReceiver_2().solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
	}

}

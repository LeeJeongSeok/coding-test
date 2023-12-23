package jeongseok.programmers.lv1;

import java.util.*;
public class ReportResultReceiver {

	HashMap<String, ArrayList<String>> map = new HashMap<>();
	HashMap<String, Integer> blackList = new HashMap<>();


	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		for (int i = 0; i < id_list.length; i++) {
			map.put(id_list[i], new ArrayList<>());
			blackList.put(id_list[i], 0);
		}


		// report 배열을 순회하면서 신고한 유저들을 집어넣는다. 이때 만약 신고했던 유저가 있다면 해당 유저는 건너뛴다.
		for (int i = 0; i < report.length; i++) {
			String[] split = report[i].split(" ");
			ArrayList<String> list = map.get(split[0]);

			if (!list.contains(split[1])) {
				list.add(split[1]);
			}

			map.put(split[0], list);
		}

		// 각 리스트를 순회하면서 신고당한 유저에 대한 map을 만든다.
		for (String key : map.keySet()) {
			ArrayList<String> list = map.get(key);

			for (int i = 0; i < list.size(); i++) {
				blackList.put(list.get(i), blackList.get(list.get(i)) + 1);
			}
		}

		int idx = 0;
		// 신고한 유저가 k명인 경우를 찾기 위해서 map에서 순회하면서 value를 조회한다.
		for (int i = 0; i < id_list.length; i++) {
			ArrayList<String> list = map.get(id_list[i]);

			for (int j = 0; j < list.size(); j++) {
				if (blackList.get(list.get(j)) >= k) {
					answer[idx]++;
				}
			}
			idx++;
		}

		return answer;
	}
	public static void main(String[] args) {
//		new ReportResultReceiver().solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
		new ReportResultReceiver().solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
	}

}

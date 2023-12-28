package jeongseok.programmers.lv1;

import java.util.*;
public class IncompleteRunner {

	public String solution(String[] participant, String[] completion) {
		String answer = "";

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < participant.length; i++) {
			map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
		}

		for (int i = 0; i < completion.length; i++) {
			map.put(completion[i], map.get(completion[i]) - 1);
		}

		for (String key : map.keySet()) {
			if (map.get(key) == 1) {
				answer = key;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		new IncompleteRunner().solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
		new IncompleteRunner().solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
		new IncompleteRunner().solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
	}

}

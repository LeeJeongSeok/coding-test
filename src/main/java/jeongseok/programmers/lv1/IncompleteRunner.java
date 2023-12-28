package jeongseok.programmers.lv1;

import java.util.*;
import java.util.Map.Entry;

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

		/**
		 * map.keySet() 방식보다 entrySet 방식으로 value 값을 가져오는게 효율성 측면에서 더 좋다.
		 */
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				answer = entry.getKey();
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

package jeongseok.programmers.lv1;

import java.util.HashMap;
import java.util.Objects;

public class PersonalityTypeTester_2 {

	public String solution(String[] survey, int[] choices) {
		StringBuilder sb = new StringBuilder();
		int[] scoreBoard = new int[]{3, 2, 1, 0, 1, 2, 3};
		HashMap<String, Integer> result = new HashMap<>();
		result.put("R", 0);
		result.put("T", 0);
		result.put("C", 0);
		result.put("F", 0);
		result.put("J", 0);
		result.put("M", 0);
		result.put("A", 0);
		result.put("N", 0);

		for (int i = 0; i < survey.length; i++) {
			int currentChoice = choices[i];
			String[] split = survey[i].split("");
			String currentDisagree = split[0];
			String currentAgree = split[1];

			if (currentChoice >= 1 && currentChoice <= 3) {
				result.put(currentDisagree, result.getOrDefault(currentDisagree, 0) + scoreBoard[currentChoice - 1]);
			} else if (currentChoice >= 5 && currentChoice <= 7) {
				result.put(currentAgree, result.getOrDefault(currentAgree, 0) + scoreBoard[currentChoice - 1]);
			}
		}

		sb.append(compareAndAdd(result, "R", "T"));
		sb.append(compareAndAdd(result, "C", "F"));
		sb.append(compareAndAdd(result, "J", "M"));
		sb.append(compareAndAdd(result, "A", "N"));

		return sb.toString();
	}

	private String compareAndAdd(HashMap<String, Integer> map, String key1, String key2) {
		if (map.get(key1) >= map.get(key2)) {
			return key1;
		} else {
			return key2;
		}
	}

	public static void main(String[] args) {
		new PersonalityTypeTester_2().solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
		new PersonalityTypeTester_2().solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3});
	}

}

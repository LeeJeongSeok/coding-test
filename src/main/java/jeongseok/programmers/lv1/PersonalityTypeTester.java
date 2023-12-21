package jeongseok.programmers.lv1;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;

public class PersonalityTypeTester {

	public String solution(String[] survey, int[] choices) {
		HashMap<String, Integer> map = new HashMap<>();
		int[] score = new int[]{0, 3, 2, 1, 0, 1, 2, 3};
		List<String> answer = new ArrayList<>();

		map.put("R", 0);
		map.put("T", 0);
		map.put("C", 0);
		map.put("F", 0);
		map.put("J", 0);
		map.put("M", 0);
		map.put("A", 0);
		map.put("N", 0);

		for(int i = 0; i < choices.length; i++) {
			String[] str = survey[i].split("");
			String disagree = str[0];
			String agree = str[1];

			if (choices[i] >= 1 && choices[i] <= 3) {
				map.put(disagree, map.get(disagree) + score[choices[i]]);
			}

			if (choices[i] >= 5 && choices[i] <= 7) {
				map.put(agree, map.get(agree) + score[choices[i]]);
			}
		}

		compareAndAdd(answer, map, "R", "T");
		compareAndAdd(answer, map, "C", "F");
		compareAndAdd(answer, map, "J", "M");
		compareAndAdd(answer, map, "A", "N");


		String result = answer.stream().collect(Collectors.joining());

		return result;
	}

	private static void compareAndAdd(List<String> answer, Map<String, Integer> map, String key1, String key2) {
		if (Objects.equals(map.get(key1), map.get(key2))) {
			answer.add(key1);
		} else if (map.get(key1) > map.get(key2)) {
			answer.add(key1);
		} else {
			answer.add(key2);
		}
	}

	public static void main(String[] args) {
		new PersonalityTypeTester().solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
		new PersonalityTypeTester().solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3});
		new PersonalityTypeTester().solution(new String[]{"RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"}, new int[]{1});
	}

}

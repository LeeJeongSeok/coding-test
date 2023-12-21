package jeongseok.programmers.lv1;

import java.util.*;
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

		if (Objects.equals(map.get("R"), map.get("T"))) {
			answer.add("R");
		} else if (map.get("R") > map.get("T")) {
			answer.add("R");
		} else {
			answer.add("T");
		}

		if (Objects.equals(map.get("C"), map.get("F"))) {
			answer.add("C");
		} else if (map.get("C") > map.get("F")) {
			answer.add("C");
		} else {
			answer.add("F");
		}

		if (Objects.equals(map.get("J"), map.get("M"))) {
			answer.add("J");
		} else if (map.get("J") > map.get("M")) {
			answer.add("J");
		} else {
			answer.add("M");
		}

		if (Objects.equals(map.get("A"), map.get("N"))) {
			answer.add("A");
		} else if (map.get("A") > map.get("N")) {
			answer.add("A");
		} else {
			answer.add("N");
		}

		String result = answer.stream().collect(Collectors.joining());

		return result;
	}

	public static void main(String[] args) {
		new PersonalityTypeTester().solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
		new PersonalityTypeTester().solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3});
		new PersonalityTypeTester().solution(new String[]{"RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"}, new int[]{1});
	}

}

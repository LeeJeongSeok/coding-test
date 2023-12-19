package jeongseok.programmers.lv1;

import java.util.*;
import java.util.stream.*;

public class PersonalityTypeTester {

	public String solution(String[] survey, int[] choices) {

		HashMap<String, Integer> first = new HashMap<String, Integer>();
		HashMap<String, Integer> second = new HashMap<String, Integer>();
		HashMap<String, Integer> third = new HashMap<String, Integer>();
		HashMap<String, Integer> forth = new HashMap<String, Integer>();
		List<String> list = new ArrayList<>();

		first.put("R", 0);
		first.put("T", 0);

		second.put("C", 0);
		second.put("F", 0);

		third.put("J", 0);
		third.put("M", 0);

		forth.put("A", 0);
		forth.put("N", 0);

		int[] score = new int[]{0, 3, 2, 1, 0, 1, 2, 3};

		for (int i = 0; i < choices.length; i++) {
			String[] ans = survey[i].split("");
			String disagree = ans[0];
			String agree = ans[1];

			if (choices[i] >= 1 && choices[i] <= 3) {

				if (first.containsKey(disagree)) {
					first.put(disagree, score[choices[i]]);
				}

				if (second.containsKey(disagree)) {
					second.put(disagree, score[choices[i]]);
				}

				if (third.containsKey(disagree)) {
					third.put(disagree, score[choices[i]]);
				}

				if (forth.containsKey(disagree)) {
					forth.put(disagree, score[choices[i]]);
				}
			}

			if (choices[i] >= 5 && choices[i] <= 7) {
				if (first.containsKey(agree)) {
					first.put(agree, score[choices[i]]);
				}

				if (second.containsKey(agree)) {
					second.put(agree, score[choices[i]]);
				}

				if (third.containsKey(agree)) {
					third.put(agree, score[choices[i]]);
				}

				if (forth.containsKey(agree)) {
					forth.put(agree, score[choices[i]]);
				}
			}
		}


		Integer firstMinValue = Collections.max(first.values());
		Integer secondMinValue = Collections.max(second.values());
		Integer thirdMinValue = Collections.max(third.values());
		Integer forthMinValue = Collections.max(forth.values());

		for (String key : first.keySet()) {
			if (first.get(key).equals(firstMinValue)) {
				list.add(key);
				break;
			}
		}

		for (String key : second.keySet()) {
			if (second.get(key).equals(secondMinValue)) {
				list.add(key);
				break;
			}
		}

		for (String key : third.keySet()) {
			if (third.get(key).equals(thirdMinValue)) {
				list.add(key);
				break;
			}
		}

		for (String key : forth.keySet()) {
			if (forth.get(key).equals(forthMinValue)) {
				list.add(key);
				break;
			}
		}

		return String.join("", list);
	}

	public static void main(String[] args) {
//		new PersonalityTypeTester().solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
		new PersonalityTypeTester().solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3});
	}

}

package jeongseok.programmers.lv1;

import java.util.*;
import java.util.stream.*;

public class PersonalityTypeTester {

	public String solution(String[] survey, int[] choices) {

		HashMap<String, Integer> first = new HashMap<>();
		HashMap<String, Integer> second = new HashMap<>();
		HashMap<String, Integer> third = new HashMap<>();
		HashMap<String, Integer> forth = new HashMap<>();

		List<String> list = new ArrayList<>();
		int[] score = new int[]{0, 3, 2, 1, 0, 1, 2, 3};

		first.put("R", 0);
		first.put("T", 0);

		second.put("C", 0);
		second.put("F", 0);

		third.put("J", 0);
		third.put("M", 0);

		forth.put("A", 0);
		forth.put("N", 0);


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


		Integer firstMaxValue = Collections.max(first.values());
		Integer secondMaxValue = Collections.max(second.values());
		Integer thirdMaxValue = Collections.max(third.values());
		Integer forthMaxValue = Collections.max(forth.values());


		List<String> firstTemp = new ArrayList<>();
		for (String key : first.keySet()) {
			if (first.get(key).equals(firstMaxValue)) {
				firstTemp.add(key);
			}
		}

		// value 값이 동일한 경우 사전순으로 정렬했을 때 가장 앞에 오는 문자가 list에 더해져야한다.
		if (firstTemp.size() >= 2) {
			Collections.sort(firstTemp);
			list.add(firstTemp.get(0));
		} else {
			list.add(firstTemp.get(0));
		}

		List<String> secondTemp = new ArrayList<>();
		for (String key : second.keySet()) {
			if (second.get(key).equals(secondMaxValue)) {
				secondTemp.add(key);
			}
		}

		if (secondTemp.size() >= 2) {
			Collections.sort(secondTemp);
			list.add(secondTemp.get(0));
		} else {
			list.add(secondTemp.get(0));
		}


		List<String> thirdTemp = new ArrayList<>();
		for (String key : third.keySet()) {
			if (third.get(key).equals(thirdMaxValue)) {
				thirdTemp.add(key);
			}
		}

		if (thirdTemp.size() >= 2) {
			Collections.sort(thirdTemp);
			list.add(thirdTemp.get(0));
		} else {
			list.add(thirdTemp.get(0));
		}

		List<String> forthTemp = new ArrayList<>();
		for (String key : forth.keySet()) {
			if (forth.get(key).equals(forthMaxValue)) {
				forthTemp.add(key);
			}
		}

		if (forthTemp.size() >= 2) {
			Collections.sort(forthTemp);
			list.add(forthTemp.get(0));
		} else {
			list.add(forthTemp.get(0));
		}


		String answer = list.stream()
			.collect(Collectors.joining());

		return answer;
	}

	public static void main(String[] args) {
//		new PersonalityTypeTester().solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
//		new PersonalityTypeTester().solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3});
		new PersonalityTypeTester().solution(new String[]{"RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"}, new int[]{1});
	}

}

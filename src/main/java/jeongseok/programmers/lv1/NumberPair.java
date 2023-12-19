package jeongseok.programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class NumberPair {

	public String solution(String X, String Y) {
		HashMap<Character, Integer> xMap = new HashMap<>();
		HashMap<Character, Integer> yMap = new HashMap<>();
		List<String> list = new ArrayList<>();

		for (int i = 0; i < X.length(); i++) {
			xMap.put(X.charAt(i), xMap.getOrDefault(X.charAt(i), 0) + 1);
		}

		for (int i = 0; i < Y.length(); i++) {
			yMap.put(Y.charAt(i), yMap.getOrDefault(Y.charAt(i), 0) + 1);
		}

		// 빈도수가 2이상인 문자만 찾아서 숫자짝궁을 만들어준다.
		for (Character c : yMap.keySet()) {
			if (!xMap.containsKey(c)) {
				continue;
			}

			int length = Math.min(xMap.get(c), yMap.get(c));
			for (int i = 0; i < length; i++) {
				list.add(String.valueOf(c));
			}
		}

		String result = list.stream()
			.sorted(Collections.reverseOrder())
			.collect(Collectors.joining());

		if (result.isEmpty()) {
			return "-1";
		} else if (result.replaceAll("0", "").isEmpty()) {
			return "0";
		} else {
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(new NumberPair().solution("100", "2345"));
		System.out.println(new NumberPair().solution("100", "203045"));
		System.out.println(new NumberPair().solution("100", "123450"));
		System.out.println(new NumberPair().solution("12321", "42531"));
		System.out.println(new NumberPair().solution("5525", "1255"));
		System.out.println(new NumberPair().solution("1035567", "1045"));
		System.out.println(new NumberPair().solution("99999999999999999999999999999999999999999999999999999999999999999999999999999999", "99999999999999999999999999999999999999999999999999999999999999999999999999999999"));
		System.out.println(new NumberPair().solution("00000000000000000000", "00000000000000000000"));
		System.out.println(new NumberPair().solution("111", "1111"));
		System.out.println(new NumberPair().solution("100", "100"));

	}

}

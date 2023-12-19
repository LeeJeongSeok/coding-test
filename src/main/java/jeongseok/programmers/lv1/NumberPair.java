package jeongseok.programmers.lv1;

import java.util.HashMap;

public class NumberPair {

	public String solution(String X, String Y) {
		HashMap<Character, Integer> xMap = new HashMap<>();
		HashMap<Character, Integer> yMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < X.length(); i++) {
			xMap.put(X.charAt(i), xMap.getOrDefault(X.charAt(i), 0) + 1);
		}

		for (int i = 0; i < Y.length(); i++) {
			yMap.put(Y.charAt(i), yMap.getOrDefault(Y.charAt(i), 0) + 1);
		}

		// 빈도수가 2이상인 문자만 찾아서 숫자짝궁을 만들어준다.
		for (Character c : yMap.keySet()) {
			if (xMap.containsKey(c)) {
				int count = (xMap.get(c) + yMap.get(c)) / 2;

				xMap.put(c, xMap.get(c) % 2);
				yMap.put(c, yMap.get(c) % 2);

				sb.append(String.valueOf(c).repeat(count));
			}
		}

		// 짝궁을 만들지 못하는 경우
		if (sb.length() == 0) {
			return "-1";
		}

		boolean flag = false;
		// 짝궁이 0인 경우
		for (int i = 0; i < sb.length(); i++) {
			flag = sb.charAt(i) == '0';
		}

		if (flag) {
			return "0";
		}

		// 숫자짝궁중 가장 큰 수를 추출한다.
		return sb.reverse().toString();
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

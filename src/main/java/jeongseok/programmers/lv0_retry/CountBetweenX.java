package jeongseok.programmers.lv0_retry;

import java.util.Arrays;

public class CountBetweenX {

	public int[] solution(String myString) {
		return Arrays.stream(myString.split("x", -1)).mapToInt(x -> x.length()).toArray();
	}

	public static void main(String[] args) {
		new CountBetweenX().solution("oxooxoxxox");
		new CountBetweenX().solution("xabcxdefxghi");
	}

}

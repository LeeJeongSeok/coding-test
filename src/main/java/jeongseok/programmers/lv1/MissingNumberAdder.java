package jeongseok.programmers.lv1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumberAdder {

	public int solution(int[] numbers) {
		return Arrays.stream(IntStream.rangeClosed(0, 9).toArray()).sum() - Arrays.stream(numbers).sum();
	}

	public static void main(String[] args) {
		System.out.println(new MissingNumberAdder().solution(new int[]{1,2,3,4,6,7,8,0}));
		System.out.println(new MissingNumberAdder().solution(new int[]{5,8,4,0,6,7,9}));
	}

}

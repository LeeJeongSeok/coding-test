package jeongseok.programmers.lv0_retry;

import java.util.stream.*;

public class ArrayElementDeleter {

	public int[] solution(int[] arr, int[] delete_list) {
		return IntStream.of(arr)
			.filter(i -> !IntStream.of(delete_list).anyMatch(s -> s == i))
			.toArray();
	}

	public static void main(String[] args) {
		new ArrayElementDeleter().solution(new int[]{293, 1000, 395, 678, 94}, new int[]{94, 777, 104, 1000, 1, 12});
	}

}

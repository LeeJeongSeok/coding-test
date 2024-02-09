package jeongseok.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 총 풀이 시간 - 53분
 */
public class _1439_ {
	static int[] arr = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char current = s.charAt(0);


		for (int i = 1; i < s.length(); i++) {
			if (current == s.charAt(i)) {
				continue;
			} else {
				arr[current - '0']++;
				current = s.charAt(i);
			}
		}

		// 반복문이 끝나고 마지막으로 확인했던 current 문자의 빈도수도 체크하기 위해 1를 증가
		arr[current - '0']++;

		if (arr[0] == arr[1]) {
			System.out.println(arr[0]);
		} else {
			System.out.println(Math.min(arr[0], arr[1]));
		}
	}
}

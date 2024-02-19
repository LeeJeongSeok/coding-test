package jeongseok.baekjoon;

/**
 * 스택을 이용한 풀이
 *
 * ( -> push
 * ) -> pop
 * 1. 만약 스택이 비어있는데 pop 연산을 하게 되면 얘는 처음부터 VPS가 될 수 없기 떄문에 NO
 * 2. 반복문이 끝나는 시점에 스택이 비어있지 않다면 NO
 * 3. 위 두 경우를 제외한 나머지는 YES
 */

import java.io.*;
import java.util.*;

public class _9012_2 {

	static int T;
	static Stack<Character> stack;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String result = isVPS(br.readLine());
			sb.append(result).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static String isVPS(String ps) {
		stack = new Stack<>();

		for (int i = 0; i < ps.length(); i++) {
			if (ps.charAt(i) == '(') {
				stack.push(ps.charAt(i));
			} else {
				if (stack.isEmpty() && ps.charAt(i) == ')') {
					return "NO";
				} else {
					stack.pop();
				}
			}
		}

		if (!stack.isEmpty()) {
			return "NO";
		} else {
			return "YES";
		}
	}

}

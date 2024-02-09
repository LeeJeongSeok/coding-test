package jeongseok.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10799_ {

	static Stack<Character> stack = new Stack<>();
	static int result = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push('(');
			}

			if (str.charAt(i) == ')') {
				stack.pop();

				if (str.charAt(i - 1) == '(') {
					result += stack.size();
				} else {
					result++;
				}
			}
		}

		System.out.println(result);
	}

}

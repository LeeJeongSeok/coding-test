package jeongseok.baekjoon;

import java.util.*;
import java.io.*;

public class _9012_ {

	static int T;
	static Stack<Character> stack;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			stack = new Stack<>();
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {
				// 스택이 비어있을 때 닫는 괄호가 들어온다면 뒤에 어떤 괄호가 와도 VPS를 완성할 수 없다.
				if (stack.isEmpty() && str.charAt(j) == ')') {
					stack.push(')');
					break;
				} else {
					if (str.charAt(j) == ')') {
						stack.pop();
					} else {
						stack.push('(');
					}
				}
			}

			if (!stack.isEmpty()) {
				sb.append("NO").append("\n");
			} else {
				sb.append("YES").append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}

package jeongseok.baekjoon;

import java.io.*;
import java.util.*;

public class _9375_2 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String item = st.nextToken(); // 여기서 의상의 이름은 필요없음
				String category = st.nextToken();

				map.put(category, map.getOrDefault(category, 0) + 1);
			}


			int result = 1; // 결과를 담을 변수 생성, 1로 초기화한 이유는 각 의상별로 경우의 수를 곱해야하는데, 이때 0으로 초기화하면 무조건 0이 되기 때문에 1로 초기화함

			for (Integer value : map.values()) {
				result *= (value + 1); // 해당 종류의 옷을 안입는 경우도 포함시켜야하기 때문에 + 1를 함
			}

			System.out.println(result - 1); // -1를 해주는 이유는 알몸이 아닌 상태로 며칠까지 가능한지를 물어보기 때문에 모든 의상에 안입는 경우를 하나 뺴줘야한다.
		}

	}

}

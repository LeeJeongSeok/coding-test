package jeongseok.programmers.lv0_retry;

import java.util.*;

public class SeparateBySpace2 {

	public String[] solution(String my_string) {
		String[] split = my_string.split(" ", -1);
		ArrayList<String> list = new ArrayList<>();

		for (String str : split) {
			if (!str.equals("")) {
				list.add(str);
			}
		}

		return list.toArray(new String[0]);
	}
	public static void main(String[] args) {
		new SeparateBySpace2().solution("i    love  you");
		new SeparateBySpace2().solution("    programmers  ");
	}

}

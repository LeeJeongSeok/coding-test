package jeongseok.programmers.lv0_retry;

public class SeparateBySpace1 {

	public String[] solution(String my_string) {
		return my_string.split(" ", -1);
	}

	public static void main(String[] args) {
		new SeparateBySpace1().solution("i love you");
	}

}

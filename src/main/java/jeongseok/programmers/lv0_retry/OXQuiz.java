package jeongseok.programmers.lv0_retry;

public class OXQuiz {

	public String[] solution(String[] quiz) {
		String[] answer = new String[quiz.length];

		for (int i = 0; i < quiz.length; i++) {
			String[] split = quiz[i].split(" ");
			int result = (Integer.parseInt(split[0])) + (Integer.parseInt(split[2]) * (split[1].equals("+") ? 1 : -1));
			answer[i] = result == Integer.parseInt(split[4]) ? "O" : "X";
		}

		return answer;
	}

	public static void main(String[] args) {
		new OXQuiz().solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"});
	}

}

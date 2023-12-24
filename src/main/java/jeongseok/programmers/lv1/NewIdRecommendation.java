package jeongseok.programmers.lv1;

public class NewIdRecommendation {

	public String solution(String new_id) {
		// 1단계: 소문자로 변환
		new_id = new_id.toLowerCase();

		// 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 문자 제거
		new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");

		// 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 대체
		new_id = new_id.replaceAll("\\.{2,}", ".");

		// 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거
		new_id = new_id.replaceAll("^\\.|\\.$", "");

		// 5단계: 빈 문자열이라면 "a" 대입
		if (new_id.isEmpty()) {
			new_id = "a";
		}

		// 6단계: 길이가 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자 제거
		//      마지막에 위치한 마침표(.) 제거
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15).replaceAll("\\.$", "");
		}

		// 7단계: 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
		while (new_id.length() <= 2) {
			new_id += new_id.charAt(new_id.length() - 1);
		}
		
		return new_id;
	}

	public static void main(String[] args) {
		new NewIdRecommendation().solution("...!@BaT#*..y.abcdefghijklm");
	}

}

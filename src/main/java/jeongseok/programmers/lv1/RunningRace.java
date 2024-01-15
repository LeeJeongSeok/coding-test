package jeongseok.programmers.lv1;

import java.util.*;

public class RunningRace {

	public String[] solution(String[] players, String[] callings) {

		HashMap<String, Integer> mappedByName = new HashMap<>();
		HashMap<Integer, String> mappedByRank = new HashMap<>();
		String[] answer = new String[players.length];

		for (int i = 0; i < players.length; i++) {
			mappedByName.put(players[i], i + 1);
			mappedByRank.put(i + 1, players[i]);
		}


		for (int i = 0; i < callings.length; i++) {

			// kai라는 선수가 불렸을 때, A에서 kai라는 선수의 등수를 먼저 구한다. -> 4등이다. (currentName, currentRank)
			int currentRank = mappedByName.get(callings[i]);
			String currentName = mappedByRank.get(currentRank);

			// kai 선수 바로 앞에 있는 선수의 등수와, 이름을 가져온다. (3등인 poe - frontName, frontRank)
			String frontName = mappedByRank.get(currentRank - 1);
			int frontRank = mappedByName.get(frontName);

			// 이제 B자료구조에서 3등인 poe와, 4등인 kai를 바꿔치기한다. 그렇다면 r의 값을 업데이트된다.
			mappedByRank.put(frontRank, currentName);
			mappedByRank.put(currentRank, frontName);

			// 현재 불린 플레이어의 이름이 담긴 currentName을 이전 플레이어의 등수인 frontRank로 변경하고
			//추월당할 플레이어의 이름이 담긴 frontName을 현재 플레이어의 등수인 currentRank로 변경한다
			mappedByName.put(currentName, frontRank);
			mappedByName.put(frontName, currentRank);
		}

		for (int i = 1; i <= players.length; i++) {
			answer[i - 1] = mappedByRank.get(i);
		}

		return answer;
	}

	public static void main(String[] args) {
		new RunningRace().solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
	}
}

package jeongseok.programmers.lv1;

import java.util.HashMap;

/**
 * 프로그래머스 레벨 1 - 대충 만든 자판
 */
public class RoughlyMadeKeyboard {

	public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < keymap.length; i++) {
			for (int j = 0; j < keymap[i].length(); j++) {
				if (map.containsKey(keymap[i].charAt(j))) {
					map.put(keymap[i].charAt(j), Math.min(map.get(keymap[i].charAt(j)), j + 1));
					continue;
				}
				map.put(keymap[i].charAt(j), j + 1);
			}
		}

		for (int i = 0; i < targets.length; i++) {
			for (int j = 0; j < targets[i].length(); j++) {
				if (!map.containsKey(targets[i].charAt(j))) {
					answer[i] = -1;
					break;
				} else {
					answer[i] += map.get(targets[i].charAt(j));
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		new RoughlyMadeKeyboard().solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"});
		new RoughlyMadeKeyboard().solution(new String[]{"AA"}, new String[]{"B"});
		new RoughlyMadeKeyboard().solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA","BGZ"});
	}
}

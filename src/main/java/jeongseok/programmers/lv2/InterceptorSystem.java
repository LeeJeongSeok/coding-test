package jeongseok.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

class Range {
	int start;
	int end;

	public Range(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class InterceptorSystem {

	public int solution(int[][] targets) {
		int answer = 1;
		ArrayList<Range> list = new ArrayList<>();

		for (int i = 0; i < targets.length; i++) {
			list.add(new Range(targets[i][0], targets[i][1]));
		}

		Collections.sort(list, (o1, o2) -> {
			if (o1.start == o2.start) {
				return o1.end - o2.end;
			}

			return o1.start - o2.start;
		});

		Range range = list.get(0);
		int currentStart = range.start;
		int currentEnd = range.end;

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).start < currentEnd) {
				currentStart = Math.max(currentStart, list.get(i).start);
				currentEnd = Math.min(currentEnd, list.get(i).end);
			} else {
				currentStart = list.get(i).start;
				currentEnd = list.get(i).end;
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		new InterceptorSystem().solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}});
	}
}

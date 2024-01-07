package jeongseok.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

class SubSequence implements Comparable<SubSequence> {

	int left = 0;
	int right = 0;
	int size = 0;

	public SubSequence(int left, int right) {
		this.left = left;
		this.right = right;
		this.size = right - left;
	}

	@Override
	public int compareTo(SubSequence o) {
		if (this.size == o.size) {
			return this.left - o.left;
		}
		return this.size - o.size;
	}
}

public class ContiguousSubsequenceSum {

	public int[] solution(int[] sequence, int k) {

		int left = 0;
		int right = 0;
		int sum = sequence[0];

		List<SubSequence> list = new ArrayList<>();

		while (true) {
			if (sum == k) {
				list.add(new SubSequence(left, right));
			}

			if (left == sequence.length && right == sequence.length) {
				break;
			}

			if (sum <= k && right < sequence.length) {
				right++;

				if (right < sequence.length) {
					sum += sequence[right];
				}
			} else {
				if (left < sequence.length) {
					sum -= sequence[left];
					left++;
				}
			}
		}

		list.sort(SubSequence::compareTo);

		return new int[]{list.get(0).left, list.get(0).right};
	}

	public static void main(String[] args) {
//		new ContiguousSubsequenceSum().solution(new int[]{1, 2, 3, 4, 5}, 7);
//		new ContiguousSubsequenceSum().solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
		new ContiguousSubsequenceSum().solution(new int[]{2, 2, 2, 2, 2}, 6);
	}

}

package jeongseok.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class FrogRiverOne {

	public int solution(int X, int[] A) {
		// Implement your solution here
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);

			if (set.size() == X) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		new FrogRiverOne().solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
	}

}

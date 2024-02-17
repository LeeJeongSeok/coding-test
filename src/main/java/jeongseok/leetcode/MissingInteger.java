package jeongseok.leetcode;

import java.util.Arrays;

public class MissingInteger {

	public int solution(int[] A) {
		// Implement your solution here
		Arrays.sort(A);
		int len = A.length;
		int result = 1;
		for(int i =0; i<len; i++){
			if(A[i] < 1 || A[i] < result)continue;
			if(A[i] > result){
				return result;
			}else{
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new MissingInteger().solution(new int[]{1, 3, 6, 4, 1, 2}));
//		System.out.println(new MissingInteger().solution(new int[]{1, 2, 3}));
		System.out.println(new MissingInteger().solution(new int[]{-1, -3}));
//		System.out.println(new MissingInteger().solution(new int[]{-2, -3, 1, 3, 2, 5, 6}));
	}

}

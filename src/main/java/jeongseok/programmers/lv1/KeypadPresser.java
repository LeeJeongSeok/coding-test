package jeongseok.programmers.lv1;

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class KeypadPresser {

	StringBuilder sb = new StringBuilder();
	Position leftHandPosition = new Position(3, 0);
	Position rightHandPosition = new Position(3, 2);


	public String solution(int[] numbers, String hand) {

		for (int i = 0; i < numbers.length; i++) {
			// 왼손인 경우
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				// 왼손 좌표 이동
				if (numbers[i] == 1) {
					leftHandPosition.x = 0;
					leftHandPosition.y = 0;
				}

				if (numbers[i] == 4) {
					leftHandPosition.x = 1;
					leftHandPosition.y = 0;
				}

				if (numbers[i] == 7) {
					leftHandPosition.x = 2;
					leftHandPosition.y = 0;
				}

				sb.append("L");
			}

			// 오른손인 경우
			if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				// 오른손 좌표 이동
				if (numbers[i] == 3) {
					leftHandPosition.x = 0;
					leftHandPosition.y = 2;
				}

				if (numbers[i] == 6) {
					leftHandPosition.x = 1;
					leftHandPosition.y = 2;
				}

				if (numbers[i] == 9) {
					leftHandPosition.x = 2;
					leftHandPosition.y = 2;
				}

				sb.append("R");
			}

			if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {

				// 두 엄지손가락의 현재 키패드 위치를 계산한다.
				if (numbers[i] == 2) {
					int targetX = 0;
					int targetY = 1;

					int distance1 = calculateDistance(leftHandPosition.x, leftHandPosition.y, targetX, targetY);
					int distance2 = calculateDistance(rightHandPosition.x, rightHandPosition.y, targetX, targetY);

					if (distance1 < distance2) {
						sb.append("L");
					} else if (distance2 > distance1){
						sb.append("R");
					} else {
						// 두 엄지 손가락의 거리가 같은 경우
						if (hand.equals("left")) {
							sb.append("L");
						} else {
							sb.append("R");
						}
					}
				}

				if (numbers[i] == 5) {
					int targetX = 1;
					int targetY = 1;

					int distance1 = calculateDistance(leftHandPosition.x, leftHandPosition.y, targetX, targetY);
					int distance2 = calculateDistance(rightHandPosition.x, rightHandPosition.y, targetX, targetY);

					if (distance1 < distance2) {
						sb.append("L");
					} else if (distance2 > distance1){
						sb.append("R");
					} else {
						// 두 엄지 손가락의 거리가 같은 경우
						if (hand.equals("left")) {
							sb.append("L");
						} else {
							sb.append("R");
						}
					}
				}

				if (numbers[i] == 8) {
					int targetX = 2;
					int targetY = 1;

					int distance1 = calculateDistance(leftHandPosition.x, leftHandPosition.y, targetX, targetY);
					int distance2 = calculateDistance(rightHandPosition.x, rightHandPosition.y, targetX, targetY);

					if (distance1 < distance2) {
						sb.append("L");
					} else if (distance2 > distance1){
						sb.append("R");
					} else {
						// 두 엄지 손가락의 거리가 같은 경우
						if (hand.equals("left")) {
							sb.append("L");
						} else {
							sb.append("R");
						}
					}
				}

				if (numbers[i] == 0) {
					int targetX = 3;
					int targetY = 1;

					int distance1 = calculateDistance(leftHandPosition.x, leftHandPosition.y, targetX, targetY);
					int distance2 = calculateDistance(rightHandPosition.x, rightHandPosition.y, targetX, targetY);

					if (distance1 < distance2) {
						sb.append("L");
					} else if (distance2 > distance1){
						sb.append("R");
					} else {
						// 두 엄지 손가락의 거리가 같은 경우
						if (hand.equals("left")) {
							sb.append("L");
						} else {
							sb.append("R");
						}
					}
				}


			}
		}

		return sb.toString();
	}

	private static int calculateDistance(int x1, int y1, int x2, int y2) {
		return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	public static void main(String[] args) {
//		new KeypadPresser().solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
		new KeypadPresser().solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
		new KeypadPresser().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");
	}
}

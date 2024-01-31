import java.util.*;

class Solution {
	public int solution(int[][] dots) {
		double[] dotList = new double[6];

		int idx = 0;
		for (int i = 0; i < dots.length - 1; i++) {
			for (int j = i + 1; j < dots.length; j++) {
				int inclineX = dots[j][0] - dots[i][0];
				int inclineY = dots[j][1] - dots[i][1];
				if (inclineX == 0) {
					idx++;
					continue;
				}
				double incline = (double)inclineY /  inclineX;
				dotList[idx++] = incline;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (dotList[i] == dotList[5 - i])
				return 1;
		}
		return 0;
	}
}
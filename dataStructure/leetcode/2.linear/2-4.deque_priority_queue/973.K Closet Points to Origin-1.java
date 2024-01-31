import java.util.*;

/* 내 풀이 */
class Solution {
	public int[][] kClosest(int[][] points, int k) {
		// 원점에서 가장 가까운 k개의 점 목록을 '순서대로' 출력.
		// 두 점의 거리는 유클리드 거리로 한다.
		PriorityQueue<int[]> dotQueue = new PriorityQueue<>((a, b) ->
		Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1]));
		int[][] res = new int[k][2];

		for (int[] point : points) {
			dotQueue.add(point);
		}
		for (int i = 0; i < k; i++) {
			res[i] = dotQueue.poll();
		}
		return res;
	}
}
import java.util.*;

/* 유클리드 거리의 우선순위 큐 순서 */
class Solution {
	static class Point {
		double distance;
		int[] point;

		public Point(double distance, int[] point) {
			this.distance = distance;
			this.point = point;
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));

		for (int[] point : points) {
			double distance = Math.sqrt((long)point[0] * point[0] + (long) point[1] * point[1]);
			pq.add(new Point(distance, point));
		}

		int[][] result = new int[k][];
		for (int i = 0; i < k; i++) {
			result[i] = pq.poll().point;
		}
		return result;
	}
}
import java.util.*;

class Solution {
	private static int calculateScoville(int front, int back) {
		return (front + (back * 2));
	}
	public int solution(int[] scoville, int K) {
		int repeat = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int scov : scoville) {
			pq.add(scov);
		}

		while (!pq.isEmpty()) {
			int front = pq.poll();
			if (front < K) {
				repeat += 1;
				if (pq.isEmpty()) {
					return -1;
				} else {
					int back = pq.poll();
					pq.add(calculateScoville(front, back));
				}
			}
		}

		return repeat;
	}
	
}
/** 다른 while문 */
//int answer = 1;
//while (pq.size() >= 2) {
//	pq.add(pq.poll() + (pq.poll() * 2));
//	if (pq.peek() >= K)
//		return answer;
//	answer++;
//}
//return -1;
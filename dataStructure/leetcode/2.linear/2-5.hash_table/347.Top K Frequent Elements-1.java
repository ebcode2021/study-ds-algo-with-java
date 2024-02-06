import java.util.*;

class Solution {
	// 빈도 순으로 k개 엘리먼트 추출
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		// 요소 빈도수 맵에 저장
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
			(o1, o2) -> o2.getValue() - o1.getValue()
		);

		pq.addAll(map.entrySet());

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = pq.poll().getKey();
		}
		return result;
	}
}

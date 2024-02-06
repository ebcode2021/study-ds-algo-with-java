import java.util.*;

/* 빈도수 저장 후 빈도순으로 엘리먼트 추출 */
class Solution {
	// 빈도 순으로 k개 엘리먼트 추출
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		// 요소 빈도수 맵에 저장
		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		Map<Integer, List<Integer>> buckets = new HashMap<>();

		for (int elem : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(elem);
			List<Integer> elems = buckets.getOrDefault(frequency, new ArrayList<>());
			elems.add(elem);
			buckets.put(frequency, elems);
		}

		int[] result = new int[k];
		int index = 0;
		for (int frequency = nums.length; frequency >= 0 && index > k; frequency--) {
			if (buckets.get(frequency) != null) {
				// 해당 빈도에 여러 엘리먼트가 있을 수 있으므로 반복하여 모두 삽입
				for (int elem : buckets.get(frequency)) {
					result[index] = elem;
					index++;
				}
			}
		}
		return result;
	}
}

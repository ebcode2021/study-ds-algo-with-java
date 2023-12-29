import java.util.*;

/* 3.HashMap 풀이. 조회 구조 개선. O(n) */
class Solution {
     public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numsMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			// target에서 num을 뺀 값이 있으면 정답으로 리턴
			if (numsMap.containsKey(target - nums[i])) {
				return new int[]{numsMap.get(target - nums[i]), i};
			}
			numsMap.put(nums[i], i);
		}
		return null;
	}
};
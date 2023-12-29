/* 1.Brute Force 풀이. O(n^2) */
class Solution {
     public int[] twoSum(int[] nums, int target) {
		int arraySize = nums.length;

		for (int i = 0; i < arraySize; i++) {
			for (int j = i + 1; j < arraySize; j++) {
				if (nums[i] + nums[j] == target)
					return new int[]{i, j};
			}
		}
		return new int[]{};
     }
};
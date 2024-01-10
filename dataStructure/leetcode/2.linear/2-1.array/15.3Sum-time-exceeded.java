import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		Arrays.sort(nums);
		int len = nums.length;

		for (int i = 0; i < len - 2; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				for (int k = j + 1; k < len; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						tmp = Arrays.asList(nums[i], nums[j], nums[k]);
						if (!result.contains(tmp))
							result.add(tmp);
					}
				}
			}
		}
		return result;
    }
}

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length;
		Arrays.sort(nums);

		for (int i = 0; i < len - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) // duplicate value X
				continue;
			for (int j = i + 1; j < len - 1; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				for (int k = j + 1; k < len; k++) {
					if (k > j + 1 && nums[k] == nums[k - 1])
						continue;
					if (nums[i] + nums[j] + nums[k] == 0) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					}
				}
			}
		}
		return result;
    }
}
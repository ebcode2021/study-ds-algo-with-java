import java.util.*;

class Solution {
	public int arrayPairSum(int[] nums) {
		int result = 0;
		int len = nums.length - 1;
		Arrays.sort(nums);

		for (int i = 0; i < len; i += 2) {
			result += nums[i];
		}
		return result;
	} 
}
import java.util.*;

/**
 * Solve 1 : O(nlogn)
 * Wrong Cnt : 0
 * Result : Runtime(5ms, Beats 98.19%), Memory(43.34MB, Beats : 50.54%)
 */
class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String num : strNums) {
            sb.append(num);
        }
		return sb.toString();
    }
}
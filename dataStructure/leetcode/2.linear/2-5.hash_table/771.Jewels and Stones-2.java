import java.util.*;

class Solution {
	public static int numJewelsInStones(String jewels, String stones) {
		Set<Character> set = new HashSet<>();
		int result = 0;

		for (Character j : jewels.toCharArray()) {
			set.add(j);
		}

		for (Character stone : stones.toCharArray()) {
			if (set.contains(stone)) {
				result += 1;
			}
		}
		return result;
	}
}
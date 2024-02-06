import java.util.*;

class Solution {
	public static int numJewelsInStones(String jewels, String stones) {
		int count = 0;
		Map<Character, Integer> freqs = new HashMap<>();

		// 돌의 빈도수 계산
		for (char s : stones.toCharArray()) {
			if (freqs.containsKey(s)) {
				freqs.put(s, freqs.get(s) + 1);
			} else {
				freqs.put(s, 1);
			}
			//freqs.put(s, freqs.getOrDefault(s, 0) + 1);
		}

		// 보석의 빈도수 합산
		for (char j : jewels.toCharArray()) {
			if (freqs.containsKey(j)) {
				count += freqs.get(j);
			}
		}
		return count;
	}
}
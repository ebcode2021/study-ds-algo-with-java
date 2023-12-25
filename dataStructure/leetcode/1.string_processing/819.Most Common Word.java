import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> ban = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> counts = new HashMap<>();
		
		String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

		for(String w : words) {
			if (!ban.contains(w)) {
				counts.put(w, counts.getOrDefault(w, 0) + 1);
			}
		}
		return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
}
import java.util.*;

/**
 * Solve 1 : O(n)
 * Wrong Cnt : 1
 * Result : Runtime(4ms, Beats 74.37%), Memory(44.62MB, Beats : 87.79%)
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[^a-z]+");
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        
        int max = 0;
        String answer = "";
        for (int i = 0; i < words.length; i++) {
            if (bannedSet.contains(words[i])) {
                continue;
            }
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            if (max < map.get(words[i])) {
                max = map.get(words[i]);
                answer = words[i];
            }
        }
        return answer;
    }
}
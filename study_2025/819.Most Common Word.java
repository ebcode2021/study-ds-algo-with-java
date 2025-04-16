import java.util.*;

/**
 * Solve 1 : O(n)
 * Wrong Cnt : 1
 * Result : Runtime(14ms, Beats 70.50%), Memory(42.62MB, Beats : 94.20%)
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

// TC, SC
/**
    paragraph -> N
    banned -> K
    words -> M
 */
class Solution2 { // O(2n + 2k + m) -> O(N) + O(K)
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[^a-z]+"); // TC : 2n, SC : m 
        Map<String, Integer> map = new HashMap<>(); 
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned)); // TC : O(2k), SC : O(2k)
        
        int max = 0;
        String answer = "";
        for (int i = 0; i < words.length; i++) { // TC : O(m)
            if (bannedSet.contains(words[i])) {  // SC : O(1)
                continue;
            }
            map.put(words[i], map.getOrDefault(words[i], 0) + 1); // O(1)
            if (max < map.get(words[i])) { // ** Collections.max 를 통해 return 시 한 번만
                max = map.get(words[i]);
                answer = words[i];
            }
        }
        return answer;
    }
}
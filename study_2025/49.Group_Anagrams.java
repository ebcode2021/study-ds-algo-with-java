import java.util.*;


/**
 * Solve : tc -> O(n * mLogm), sc -> O(n * m)
 * Try : 1
 * Result : Runtime(7ms, Beats 65.60%), Memory(47.69MB, Beats : 91.09%)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
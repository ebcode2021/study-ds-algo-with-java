import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> storage = new HashMap<>();
        
        for (int num : array) {
            storage.put(num, storage.getOrDefault(num, 0) + 1);
        }
        
        int cnt = 0;
        // 가장 많이 나타나는 횟수
        int max = Collections.max(storage.values());
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : storage.entrySet()) {
            if (entry.getValue() == max) {
                cnt++;
                result = entry.getKey();
            }
        }
        return cnt == 1 ? max : -1;
    }
}
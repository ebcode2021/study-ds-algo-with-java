import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photos.length];
        for (int i = 0; i < photos.length; i++) {
            String[] photo = photos[i];
            for (String p : photo) {
                answer[i] += map.getOrDefault(p, 0);
            }
        }
        
        return answer;
    }
}
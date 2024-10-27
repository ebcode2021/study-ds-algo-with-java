import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    private void swapPlayers(String[] players, int idx) {
        String frontPlayer = players[idx - 1];
        players[idx - 1] = players[idx];
        players[idx] = frontPlayer;
        
        map.put(players[idx - 1], idx - 1);
        map.put(players[idx], idx);
    }
    
    public String[] solution(String[] players, String[] callings) {
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String calling : callings) {
            int idx = map.get(calling);
            swapPlayers(players, idx);
        }
        return players;   
    }
}
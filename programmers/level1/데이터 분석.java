import java.util.*;

class Solution {
    
    private Map<String, Integer> map = new HashMap<>();
    
    private void initMap() {
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
    }
    
    public int[][] solution(int[][] datas, String ext, int val_ext, String sort_by) {
        
        List<int[]> list = new ArrayList<>();
        
        initMap();
        
        int standard = map.get(ext);
        int sortStandard = map.get(sort_by);
        
        for (int[] data : datas) {
            if (data[standard] < val_ext) {
                list.add(data);
            }
        }
        
        list.sort((a, b) -> Integer.compare(a[sortStandard], b[sortStandard]));
        
        return list.toArray(new int[list.size()][]);
        
    }
}
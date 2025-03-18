import java.util.*;

/**
 * Solve 1 : O(n^2)
 * Try : 3
 * TestCase : [[1,4], [1,4]], [[1,4], [2,3]]
 * Result : Runtime(83ms, Beats 5.51%), Memory(46.71MB, Beats : 38.89%)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. intervals 정렬
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // 2.checked가 포함된 3차원 배열 생성(unchecked -> -1)
        int[][] checkIntervals = new int[intervals.length][3];
        for (int i = 0; i < intervals.length; i++) {
            checkIntervals[i][0] = intervals[i][0];
            checkIntervals[i][1] = intervals[i][1];
            checkIntervals[i][2] = 0;
        }

        // 3. O(n^2)으로 순회
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                // 뒤의 시작점이 앞의 도착점보다 작은 값이 아닐때
                if (!(checkIntervals[i][1] >= checkIntervals[j][0])) {
                    i = j - 1;
                    break;
                } else {
                    checkIntervals[i][1] = Math.max(checkIntervals[i][1], checkIntervals[j][1]);
                    checkIntervals[j][2] = -1;
                }
            }
        }
        
        // 4. 새로운 배열 반환
        return Arrays.stream(checkIntervals)
                     .filter(interval -> interval[2] == 0)
                     .map(interval -> new int[]{interval[0], interval[1]})
                     .toArray(int[][]::new);
    }
}
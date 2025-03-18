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

        // 2.checked가 포함된 3차원 배열 생성(unchecked = -1)
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
                    i = j - 1; // 병합된 부분은 이후 다시 비교하지 않음
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

/**
 * Solve 2 : O(nlogn)
 * Try : 1
 * Result : Runtime(8ms, Beats 86.84%), Memory(46.77MB, Beats : 38.89%)
 */
class Solution2 {
    public int[][] merge(int[][] intervals) {
        // 1. intervals 정렬 -> 뒤의 요소까지 비교할 필요 X
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2.checked가 포함된 3차원 배열 생성(unchecked = -1) -> 리스트 변경
        List<int[]> intervalList = new ArrayList<>();

        // 3. O(n^2)로 순회 -> O(n)로 순회
        for (int[] interval : intervals) {
            if (intervalList.isEmpty() || intervalList.get(intervalList.size() - 1)[1] < interval[0]) {
                intervalList.add(interval);
            } else {
                intervalList.get(intervalList.size() - 1)[1] = Math.max(intervalList.get(intervalList.size() - 1)[1], interval[1]);
            }
        }
        
        // 4. 새로운 배열 반환 -> 2에서 만든 리스트를 배열로 반환
        return intervalList.toArray(new int[intervalList.size()][]);
    }
}

/**
 * Solve 3 : O(nlogn)
 * Try : 1
 * Result : Runtime(8ms, Beats 86.84%), Memory(46.45MB, Beats : 83.63%)
 * url : https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#sort-double:A-
 */
class Solution3 {
    public int[][] merge(int[][] intervals) {
        // 1. intervals 정렬 -> 뒤의 요소까지 비교할 필요 X
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2.checked가 포함된 3차원 배열 생성(unchecked -> -1) -> 리스트 변경 -> 배열 생성
        int[][] result = new int[intervals.length][2];
        int idx = 0;

        // 3. O(n^2)로 순회 -> O(n)로 순회
        for (int[] interval : intervals) {
            if (idx == 0 || result[idx - 1][1] < interval[0]) {
                result[idx++] = interval;
            } else {
                result[idx - 1][1] = Math.max(result[idx - 1][1], interval[1]);
            }
        }
        
        // 4. 새로운 배열 반환 -> 2에서 만든 리스트를 배열로 반환 -> copyOf() 사용
        return Arrays.copyOf(result, idx);
    }
}
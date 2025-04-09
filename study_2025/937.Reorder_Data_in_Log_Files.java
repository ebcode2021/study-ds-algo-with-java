import java.util.*;

/**
 * Solve 1 : O(n)
 * Wrong Cnt : 0
 * Result : Runtime(4ms, Beats 74.37%), Memory(44.62MB, Beats : 87.79%)
 */
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String[] split = log.split(" ", 2);
            if (Character.isDigit(split[1].charAt(0))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        Collections.sort(letterLogs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            int cmp = split1[1].compareTo(split2[1]);
            if (cmp == 0) {
                return split1[0].compareTo(split2[0]);
            }
            return cmp;
        });

        List<String> result = new ArrayList<>();
        result.addAll(letterLogs);
        result.addAll(digitLogs);

        return result.toArray(new String[0]);
    }
}
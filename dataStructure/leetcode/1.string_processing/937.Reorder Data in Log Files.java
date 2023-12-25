import java.util.ArrayList;
import java.util.List;

class Solution {

    public String[] reorderLogFiles(String[] logs) {   
        List<String> letterLogs= new ArrayList<>();
        List<String> digitLogs= new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0)) == true) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        letterLogs.sort((s1, s2) -> {
            // 식별자와 다른 부분들
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            // 문자 로그 사전순 비교
            int compared = s1x[1].compareTo(s2x[1]);
            // 문자가 동일한 경우 식별자 비교
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            }
            // 비교 대상의 순서가 동일한 경우 0. 순서가 앞인 경우 양수 순서가 뒤인 경우 음수
            return compared;
        });

        // 문자 리스트 뒤로 숫자 리스트 이어 붙이기
        letterLogs.addAll(digitLogs);

        // 리스트를 String 배열로 변환하여 리턴
        return letterLogs.toArray(new String[0]);
    }
}
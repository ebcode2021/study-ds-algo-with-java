import java.util.*;

class Solution {
    
    static int calculation(int front, int back, String expression) {
        switch(expression) {
            case "+" :
                return front + back;
            case "-" :
                return front - back;
            case "*" :
                return front * back;
        }
        return front / back;
    }
    
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        int idx = 0;
        for (String question : quiz) {
            String[] parseQuestion = question.split(" ");
            int front = Integer.parseInt(parseQuestion[0]);
            int back = Integer.parseInt(parseQuestion[2]);
            String expression = parseQuestion[1];
            
            int res = calculation(front, back, expression);
            if (res == Integer.parseInt(parseQuestion[4])) {
                answer[idx++] = "O";
            } else {
                answer[idx++] = "X";
            }
        }
        
        return answer;
    }
}
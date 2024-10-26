class Solution {
    public int solution(String[][] board, int x, int y) {
        int n = board[0].length;
        
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        String color = board[x][y];
        
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int currentX = x + dx[i];
            int currentY = y + dy[i];
            
            if (currentX < 0 || currentX >= n || currentY < 0 || currentY >= n) {
                continue;
            } else if (!board[currentX][currentY].equals(color)) {
                continue;
            }
            count++;
        }
        return count;
    }
}
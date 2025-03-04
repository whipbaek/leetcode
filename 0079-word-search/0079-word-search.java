import java.util.*;

class Solution {

    public static boolean answer;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static int r;
    public static int c;
    public boolean exist(char[][] board, String word) {
        
        answer = false;
        r = board.length;
        c = board[0].length;
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                // visited
                boolean[][] visited = new boolean[r][c];
                visited[i][j] = true;
                if(!answer){
                recur(i, j ,visited, board, word, new StringBuilder().append(board[i][j]));
                }
                visited[i][j] = false;
            }
        }
        return answer;
    }

    public void recur(int x, int y, boolean[][] visited, char[][] board, String word, StringBuilder sb) {

        if(answer) return;
        if(sb.toString().length() > word.length()) return;
        if(!sb.toString().equals(word.substring(0, sb.toString().length()))) return;
        if(sb.toString().equals(word)){
            answer = true;
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny]) {

                visited[nx][ny] = true;
                recur(nx, ny, visited, board, word, new StringBuilder(sb.toString()).append(board[nx][ny]));
                visited[nx][ny] = false;
            }
        }
    }
}
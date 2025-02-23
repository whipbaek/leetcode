import java.util.*;

class Solution {

    public int x = 0;
    public int y = 0;
    public int r = 0;
    public int c = 0;
    public List<Integer> answer = new ArrayList<>();
    public boolean[][] visited;

    // right, down, left, up
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        r = matrix.length;
        c = matrix[0].length;
        visited = new boolean[r][c];
        answer.add(matrix[0][0]);
        visited[0][0] = true;

        
        while(true){
            int cnt = 0;
            if(!move(0, matrix)) cnt++;
            if(!move(1, matrix)) cnt++;
            if(!move(2, matrix)) cnt++;
            if(!move(3, matrix)) cnt++;
            if(cnt == 4) break;
        }

        return answer;
    }

    public boolean move(int idx, int[][] matrix){
        int nx = x + dx[idx];
        int ny = y + dy[idx];
        
        // 범위 밖으로 나가거나, 방문한거면 false -> 더이상 갈곳이 없음.
        if(nx >= r || nx < 0 || ny >= c || ny < 0 || visited[nx][ny]) return false;
        answer.add(matrix[nx][ny]);
        visited[nx][ny] = true;
        while(true){
            nx = nx + dx[idx];
            ny = ny + dy[idx];

            if(nx >= r || nx < 0 || ny >= c || ny < 0 || visited[nx][ny]) break;    
            answer.add(matrix[nx][ny]);
            visited[nx][ny] = true;
        }

        x = nx - dx[idx];
        y = ny - dy[idx];

        return true;
    }
}
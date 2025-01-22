import java.util.*;

// 1로부터 bfs 를 수행하면 끗

class Solution {

    static class Node {
        public int x;
        public int y;

        public Node (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int[][] highestPeak(int[][] isWater) {

        int dx[] = {0, 0, -1, 1};
        int dy[] = {1, -1, 0, 0};

        int r = isWater.length;
        int c = isWater[0].length;

        boolean[][] visited = new boolean[r][c];
        Deque<Node> queue = new ArrayDeque<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(isWater[i][j] == 1){
                    visited[i][j] = true;
                    queue.addLast(new Node(i, j));
                }
            }
        }

        while(!queue.isEmpty()){
            Node node = queue.removeFirst();

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny]){
                    queue.addLast(new Node(nx, ny));
                    visited[nx][ny] = true;
                    isWater[nx][ny] = isWater[node.x][node.y] + 1;
                }
            }

        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                isWater[i][j]--;
            }
        }

        return isWater;
    }
}
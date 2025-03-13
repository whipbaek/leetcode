class Solution {

    public class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int answer = 0;
        
        boolean[][] visited = new boolean[r][c];

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                // 방문하지 않았으며 '1' 인 경우
                if(!visited[i][j] && grid[i][j] == '1'){
                    Deque<Node> queue = new ArrayDeque<>();
                    queue.addLast(new Node(i, j));
                    visited[i][j] = true;

                    while(!queue.isEmpty()){
                        Node node = queue.removeFirst();
                        for(int k=0; k<4; k++){
                            int nx = node.x + dx[k];
                            int ny = node.y + dy[k];

                            if(nx >=0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && grid[nx][ny] == '1'){
                                visited[nx][ny] = true;
                                queue.addLast(new Node(nx, ny));
                            }
                        }
                    }

                    answer++;
                }
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {

    static class Node {
        public int x;
        public int y;
        public int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public int minTimeToReach(int[][] moveTime) {

        int r = moveTime.length;
        int c = moveTime[0].length;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int[][] visited = new int[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(0, 0, 0));
        visited[0][0] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.removeFirst();
            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 범위 체크
                if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    // 현재 값으로 이동이 가능한지 판단한다.
                    if(node.cnt >= moveTime[nx][ny]) {
                        if(node.cnt + 1 < visited[nx][ny]){ // 최소값인지 
                            queue.addLast(new Node(nx, ny, node.cnt+1));
                            visited[nx][ny] = node.cnt+1;
                        }
                    // 현재값으로 안된다면? -> 시간을 기다려야 하는 경우. -> 원하는 칸의 moveTime + 1 에 도달이 가능.
                    } else {
                        if(visited[nx][ny] > moveTime[nx][ny] + 1) {
                            queue.addLast(new Node(nx, ny, moveTime[nx][ny] + 1));
                            visited[nx][ny] = moveTime[nx][ny] + 1;
                        }
                    }
                }
            }
        }

        return visited[r-1][c-1];
    }
}
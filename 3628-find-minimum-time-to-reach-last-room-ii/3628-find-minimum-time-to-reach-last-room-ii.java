import java.util.*;

class Solution {

    static class Node {
        public int x;
        public int y;
        public int cnt;
        public boolean flag; // true 1초, false 2초
        
        public Node(int x, int y, int cnt, boolean flag) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.flag = flag;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        // 한 번 이동할때 1초, 2초씩 걸린다.
        int r = moveTime.length;
        int c = moveTime[0].length;

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { 1, -1, 0, 0 };

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        boolean[][] visited = new boolean[r][c]; // 최소 시간

        queue.add(new Node(0, 0, 0, true));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll(); // 가중치가 가장 작은 노드를 꺼낸다.

            if(node.x == r-1 && node.y == c-1) return node.cnt;

            // 주변을 탐색한다.
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 범위 검사
                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if(visited[nx][ny]) continue;

                    visited[nx][ny] = true; // 방문처리

                    int val = moveTime[nx][ny] > node.cnt ? moveTime[nx][ny] : node.cnt;
                    int weight = node.flag ? 1 : 2 ;
                    queue.add(new Node(nx, ny, val + weight, !node.flag));
                }
            }
        }

        return -1;
    }
}
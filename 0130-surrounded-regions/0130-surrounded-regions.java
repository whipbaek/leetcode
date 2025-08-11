class Solution {
    static class Node {
        public int x;
        public int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        int[][] flag = new int[r][c]; // 방문여부 
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        HashMap<Integer, Boolean> map = new HashMap<>(); // 각 번호 처리

        int cnt = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++){
                // 방문하지 않은 O 구역일경우
                if(board[i][j] == 'O' && flag[i][j] == 0) {
                    // bfs 를 수행한다. (이때 가장자리에 걸치는지도 확인이 필요하다.)
                    Deque<Node> queue = new ArrayDeque<>();
                    queue.addLast(new Node(i, j));
                    cnt++;
                    flag[i][j] = cnt; // 방문처리
                    map.put(cnt, false); 
                    
                    while(!queue.isEmpty()) {
                        Node temp = queue.removeFirst();
                        int x = temp.x;
                        int y = temp.y;

                        // 여기서 검사해야함.
                        if(x == 0 || x == r-1) {
                            map.put(cnt, true);
                        }

                        if(y == 0 || y == c-1) {
                            map.put(cnt, true);
                        }

                        for(int k=0; k<4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx >= 0 && nx < r && ny >= 0 && ny < c && flag[nx][ny] == 0 && board[nx][ny] == 'O') {
                                queue.add(new Node(nx, ny));
                                flag[nx][ny] = cnt;
                            }
                        }
                    }
                }
            }
        }

        // for(int i=0; i<r; i++) {
        //     for(int j=0; j<c; j++) {
        //         System.out.print(flag[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++){
                if(flag[i][j] != 0 && !map.get(flag[i][j])) {
                    board[i][j] = 'X';
                }
            }
        }

        // for(Integer key : map.keySet()) {
        //     System.out.println(key + " : " + map.get(key));
        // }


    }
}
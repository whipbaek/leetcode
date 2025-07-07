class Solution {
    public void gameOfLife(int[][] board) {
        // 살아있는 이웃이 2명보다 작으면 죽는다.
        // 주변 세포가 2,3개 살아있으면 다음 세대로 살아남는다.
        // 살아있는데 주변에 4개가 있으면 인구과잉으로 죽는다.
        // 죽었는데 주변에 3개가 있으면 살아난다.

        int r = board.length;
        int c = board[0].length;
        int[][] answer = new int[r][c];


        int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++){

                int deadCell = 0;   
                int liveCell = 0;

                for(int k=0; k<8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // 범위 체크
                    if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if(board[nx][ny] == 0) deadCell++;
                        if(board[nx][ny] == 1) liveCell++;
                    }
                }

                // System.out.println("board[" + i + "][" + j + "] : " + board[i][j]);
                // System.out.println("deadCell : " + deadCell);
                // System.out.println("liveCell : " + liveCell);
                // System.out.println();

                // 해당 세포가 죽은경우
                if(board[i][j] == 0 && liveCell == 3) {
                    answer[i][j] = 1;
                }

                // 살아있는 세포의 경우
                if(board[i][j] == 1) {

                    if(liveCell < 2 || liveCell > 3) { // 해당 세포가 죽는 경우
                        answer[i][j] = 0;
                        continue;
                    }

                    answer[i][j] = 1;
                }
            }
        }

        // copy
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                board[i][j] = answer[i][j];
            }
        }


    }
}
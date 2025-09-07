class Solution {
    public int matrixScore(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        // 행 같은 경우에는 한 번 바꾸면 끝 (어차피 가장 앞이 커야함)
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 1) break;
                if(grid[i][j] == 0) {
                    checkRow(grid, i);
                    break;
                }
            }
        }

        // 열 같은 경우에는 0이 많으면 체인지
        for(int i=0; i<c; i++) {
            int cntZero = 0;
            int cntOne = 0;

            for(int j=0; j<r; j++) {
                if(grid[j][i] == 0) cntZero++;
                else cntOne++;
            }

            if(cntZero > cntOne) {
                checkCol(grid, i);
            }
        }

        int answer = 0;
        for(int i=0; i<r; i++) {
            int sum = 0;
            int val = 1;
            for(int j=c-1; j>=0; j--) {
                if(grid[i][j] == 1) {
                    sum += val;
                }
                val*=2;
            }
            answer += sum;
        }

        return answer;
    }

    public int[][] checkRow(int [][] grid, int row) {
        for(int i=0; i<grid[row].length; i++) {
            grid[row][i] = grid[row][i] == 0 ? 1 : 0;
        }
        return grid;
    }

    public int[][] checkCol(int [][] grid, int col) {
        for(int i=0; i<grid.length; i++) {
            grid[i][col] = grid[i][col] == 0 ? 1 : 0;
        }
        return grid;
    }
}
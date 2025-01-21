import java.util.*;

// 최대 배열 크기는 10만
// 밑으로 내려오는 순간, 못 올라온다.
// 어느 지점에서 내려올것인가?
class Solution {

    static int c;

    public long gridGame(int[][] grid) {

        c = grid[0].length;

        return process(grid, new long[c], new long[c]);
    }

    public long process(int[][] grid, long[] firstSum, long[] secondSum){
        
        firstSum[0] = grid[0][0];

        for (int i = 1; i < c; i++) {
            firstSum[i] += (grid[0][i] + firstSum[i-1]) ;
        }

        secondSum[c - 1] = grid[1][c - 1];
        for (int i = c-2; i >= 0; i--) {
            secondSum[i] += (grid[1][i] + secondSum[i+1]);
        }

        long minVal = Long.MAX_VALUE;
        for(int i=0; i<c; i++){
            minVal = Math.min(minVal, Math.max(firstSum[c-1] - firstSum[i], secondSum[0] - secondSum[i]));
        }

        return minVal;
    }
}
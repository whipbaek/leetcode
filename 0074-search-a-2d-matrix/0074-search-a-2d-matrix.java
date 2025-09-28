class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;
        int end = matrix.length-1; // 행 길이
        int row = 0;

        boolean isBig = true;

        for(int i=1; i<=end; i++) {
            if(target < matrix[i][0]) {
                row = i-1;
                break;
            }
            row = i;
        }

        start = 0;
        end = matrix[row].length-1;
        
        
        while(true) {
            if(start > end) return false;

            int mid = (start + end) / 2;

            // 값을 찾으면
            if(target == matrix[row][mid]) return true;

            // 작으면 왼쪽편 탐색
            if(target < matrix[row][mid]) {
                end = mid-1;
                continue;
            }

            if(target > matrix[row][mid]) {
                start = mid+1;
                continue;
            }
        }       
    }
}
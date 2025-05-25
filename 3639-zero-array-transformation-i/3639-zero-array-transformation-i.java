class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        
        int[] start = new int[nums.length + 1];
        int[] end = new int[nums.length + 1];

        for(int[] query : queries) {
            start[query[0]]++;
            end[query[1] + 1]++;
        }

        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum = sum + start[i] - end[i];
            if(nums[i] > sum) return false;
        }

        return true;
    }
}
class Solution {
    public boolean canJump(int[] nums) {

        int len = nums.length;
        int start = 0;
        int end = nums[0];
        
        if(end >= len -1) return true;

        for(int i=start+1; i<=end; i++) {
            if(i + nums[i] > end) {
                start = i;
                end = i + nums[i];
                if(end >= len -1) return true;
                continue;
            }
        }

        return false;
    }
}
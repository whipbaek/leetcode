import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        int[] leftSum = new int[len];
        int[] rightSum = new int[len];

        leftSum[0] = nums[0];
        for(int i=1; i<len; i++){
            leftSum[i] = nums[i] * leftSum[i-1];
        }

        rightSum[len-1] = nums[len-1];
        
        for(int i=len-2; i>=0; i--){
            rightSum[i] = nums[i] * rightSum[i+1];
        }

        for(int i=0; i<len; i++){
            if(i==0){
                answer[i] = rightSum[i+1];
            } else if(i==len-1){
                answer[i] = leftSum[i-1];
            } else {
                answer[i] = leftSum[i-1] * rightSum[i+1];
            }
        }

        return answer;
    }
}
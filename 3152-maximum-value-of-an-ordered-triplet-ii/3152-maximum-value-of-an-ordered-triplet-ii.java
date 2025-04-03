import java.util.*;

class Solution {

    public long maximumTripletValue(int[] nums) {

        //예외 케이스. nums len이 짧으면?
        int len = nums.length;
        if(len < 3) return 0L;

        long[] prefix = new long[len]; // prefix[i] => nums[0] 에서 nums[i] 까지 값 중 가장 큰 값
        long[] suffix = new long[len]; // suffix[i] => nums[i] 에서 nums[len-1] 까지 값 중 가장 큰 값

        int val = nums[0];
        prefix[0] = val;

        // setup prefix
        for(int i=1; i<len; i++) {
            if(nums[i] > val) {
                val = nums[i];
            }
            prefix[i] = val;
        }

        // setup suffix
        val = nums[len-1];
        suffix[len-1] = val;

        for(int i=len-2; i>=0; i--) {
            if(nums[i] > val) {
                val = nums[i];
            }
            suffix[i] = val;
        }

        long answer = 0L;
        for(int i=1; i<len-1; i++) {
            answer = Math.max(answer, (prefix[i-1] - nums[i]) * suffix[i+1]);
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int answer = 0;
        if(len == 1) return answer;

        int target = prices[0];
        for(int i=1; i<len; i++){
            if(target < prices[i]) {
                answer = Math.max(answer, prices[i] - target);
            } else{
                target = prices[i];
            }
        }

        return answer;
    }
}
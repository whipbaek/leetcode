import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {

        // 올라가면 계속 갱신해주고, 내려가면 팔아준다.
        // 그럼 첫 구매 타이밍은?
        // 처음에는..
        // 처음에는 나보다 큰 값이 뒤에 존재하는지 확인한다.
        // 1인 경우에는 5나.. 3이나 등등
        // 처음에 flag를 건다.
        
        int answer = 0;
        int len = prices.length;
        boolean increase = false;
        
        int target = prices[0];

        // 첫 target은 increase 가 되는 시점의 값이여야한다.
        // 파는 순간은 다음 값이 decrease 되는 순간.

        // 판 이후에는 다시 increase 가 되는 순간을 찾아서 target 을 갱신한다.
        // increase flag 로 판단한다. 
        for(int i=0; i<len; i++){

            // 현재 값이 오르는 경우라면?
            // 다음값을 확인한다. -> d
            if(increase) {
                if(i == len-1){
                    // 마지막 값이라면.
                    answer += prices[i] - target;
                    break;
                }

                // 마지막 값이 아닐경우
                // 다음값이 내려가는 값이면
                if(prices[i+1] < prices[i]){
                    increase = false;
                    answer += prices[i] - target;
                }

                // 다음값이 같거나, 올라가는값이면 nothing to do
                continue;
            }

            // 현재 target을 찾는 경우라면 (increase 가 아니다.)
            // 마지막 값이라면 그냥 pass 한다.
            if(i == len - 1){
                break;
            }

            if(prices[i] < prices[i+1]){
                increase = true;
                target = prices[i];
            }
        } 

        return answer;
    }
}
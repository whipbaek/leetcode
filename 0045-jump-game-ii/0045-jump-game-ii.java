import java.util.*;
// 마지막 칸으로 가기 위해 최소 점프 횟수는 몇인가?
// dp[n] => n으로 오는데 최소 횟수

class Solution {
    public int jump(int[] nums) {

        int len = nums.length;

        int target = 0;
        int[] dp = new int[len];
        for(int i=0; i<len; i++){
            dp[i] = Integer.MAX_VALUE;    
        }
        dp[0] = 0;

        int from = 0; // 초기 from
        int to = nums[0]; // 초기 to
        int cnt = 1;
        int nextTo = -1;

        for(int i=0; i<len-1;){
            System.out.println("from : " + from);
            System.out.println("to : " + to);

            // cnt 를 갱신해줘야하는 구간
            for(int j=from+1; j<=to; j++){
                if(j >= len) break;
                nextTo = Math.max(nextTo, j + nums[j]);
                dp[j] = cnt;
            }

            // 다음구간을 설정해준다.
            from = to;
            to = nextTo;
            cnt++;
            

            i = from;
        }

        // for(int i=0; i<len; i++){
            // System.out.print(dp[i] + " ");
        // }
        // System.out.println();

        return dp[len-1];
    }
}

/**
[2, 3, 1, 1, 4]

to = 2
nextTo = 4

1, 2 는 cnt 1
이후 from = to
to = nextTo

from => 2
to => 4

nextTo = 8
from = 4
to = 8



 */
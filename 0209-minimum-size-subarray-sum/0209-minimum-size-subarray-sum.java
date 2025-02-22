import java.util.*;

// two pointer 로 값이 target 을 넘지 않으면 rear++ , 넘으면 front++
// 제일 짧은 length 를 기억해둔다.
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int front = 0;
        int rear = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        while(rear < nums.length) {
            
            // 현재 상태에서 sum 이 넘으면? -> target 에 안들어가질때까지 front를 땡겨준다.
            // 또는 rear 와 같을때까지. 넘으면 안됨!

            sum += nums[rear];

            while(sum >= target && front <= rear) {
                answer = Math.min(answer, rear - front);
                sum -= nums[front];
                front++;
            }

            rear++;
        }

        return answer != Integer.MAX_VALUE ? answer + 1 : 0 ;
    }
}
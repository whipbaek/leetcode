import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {

        int cnt = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            pq.add((long)nums[i]);
        }

        while(true){
            long x = pq.poll();
            if(x >= k){
                break;
            }
            long y = pq.poll();

            pq.add(Math.min(x,y) * 2 + Math.max(x, y));
            cnt++;
        }

        return cnt;
    }
}
import java.util.*;

class Solution {

    public long countBadPairs(int[] nums) {

        int len = nums.length;
        long cnt = 0L;

        long total = 0L;
        for(int i=1; i<len; i++){
            total += i;
        }

        System.out.println("total : " + total);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0] - 0, 1);

        for(int i=1; i<len; i++){
            int target = nums[i] - i;
            if(map.containsKey(target)){
                cnt += map.get(target);
                map.put(target, map.get(target) + 1);
            } else{
                map.put(target, 1);
            }
        }

        return total - cnt;
    }
}
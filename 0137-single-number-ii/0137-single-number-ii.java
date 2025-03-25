import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 특정요소가 한번만 나오는걸 어떻게 알 수 있을까?
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : map.keySet()) {
            if(map.get(key) == 1) return key;
        }

        return -1;
    }
}
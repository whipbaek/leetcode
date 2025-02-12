import java.util.*;

class Solution {

    public int maximumSum(int[] nums) {
        int answer = -1;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int digitSum = 0;
            while(num != 0){
                digitSum += num%10;
                num/=10;
            }

            if(!map.containsKey(digitSum)){
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(nums[i]);
                map.put(digitSum, pq);
            } else{
                map.get(digitSum).add(nums[i]);
            }
        }

        for(Integer key : map.keySet()){
            System.out.println("key : " + key);
            if(map.get(key).size() < 2) {
                continue;
            }
            int temp = 0;
            temp += map.get(key).poll();
            temp += map.get(key).poll();

            answer = Math.max(answer ,temp);
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        // 0, 1, 2 순서로 정렬이 필요하다.

        // 그냥 각각 개수를 세고 0부터 채우면 안되나?

        int zeroCnt = 0;
        int oneCnt = 0;
        int twoCnt = 0;

        for(int num : nums) {
            if(num == 0) zeroCnt++;
            if(num == 1) oneCnt++;
            if(num == 2) twoCnt++;
        }

        for(int i=0; i<nums.length; i++) {
            if(zeroCnt != 0) {
                nums[i] = 0;
                zeroCnt--;
                continue;
            }

            if(oneCnt != 0) {
                nums[i] = 1;
                oneCnt--;
                continue;
            }

            if(twoCnt != 0) {
                nums[i] = 2;
                twoCnt--;
                continue;
            }
        }
    }
}
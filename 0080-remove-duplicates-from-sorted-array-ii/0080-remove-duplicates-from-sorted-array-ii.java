import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        int mv = Integer.MAX_VALUE;
        int len = nums.length;

        int target = nums[0];
        int count = 1;

        for (int i = 1; i < len; i++) {
            // 이전값과 다른 경우 -> target과 count 를 초기화
            if (target != nums[i]) {
                target = nums[i];
                count = 1;
                continue;
            }

            // 이전값과 같은 경우 count를 증가한다. 3번이상 나온값이면 -1로 처리.
            if (count >= 2) {
                nums[i] = mv;
            }
            count++;
        }

        int pre = -1;
        int back = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == mv) {
                pre = i;
                break;
            }
        }
        if (pre == -1) {
            return len;
        }

        for (int i = pre; i < len; i++) {
            if (nums[i] != mv) {
                back = i;
                break;
            }
        }

        if(back == -1){
            return pre;
        }

        // pre 값이 그느로면 -> 문제 없음 length 반환
        // 초기 back이 넘어가면 -> pre값 반환

        while (back < len) {
            // swap 해준다.
            int temp = nums[pre];
            nums[pre] = nums[back];
            nums[back] = temp;

            // 다시 swap target을 찾는다.
            pre++;
            while (true) {
                back++;
                if (back >= len)
                    break;
                if (nums[back] != mv) {
                    break;
                }
            }
        }

        return pre;
    }
}
import java.util.*;

class Solution {
    public int[] minOperations(String boxes) {
        // 연산 한 번에 인접박스로 옮길 수 있다.
        int len = boxes.length();
        int[] answer = new int[len];

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(i == j) continue;
                if(boxes.charAt(j) == '0') continue;
                answer[i] += Math.abs(i - j);
            }
        }

        return answer;
    }
}
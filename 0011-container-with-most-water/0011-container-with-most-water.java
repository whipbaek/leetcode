import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int front = 0;
        int back = height.length - 1;
        int answer = -1;
        while(front != back){
            int val = Math.min(height[front], height[back]);
            answer = Math.max(answer, val * Math.abs(front - back));

            if(height[front] < height[back]){
                front++;
            } else{
                back--;
            }
        }
        return answer;
    }
}
import java.util.*;


// n = 10,000
// n^2 = 100,000,000
/*

boolean visited[nums.length]
0부터 시작해서 bfs 한다.
while(isempty){
    node = pop;
    for(val : nums[node]){
        if(not visited val){
            pop에 넣어준다.
        }
    }
}

*/
class Solution {
    public boolean canJump(int[] nums) {

        int goal = nums.length - 1;
        int from = nums.length - 2;
        boolean possible = false;
        while(from >= 0){
            if(from + nums[from] >= goal){
                goal = from;
            }
            from--;
        }
        return goal == 0;
    }
}
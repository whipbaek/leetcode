import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] check = new boolean[nums.length];
        func(answer, list, check, nums);
        return answer;
    }

    public void func(List<List<Integer>> answer, List<Integer> list, boolean[] check, int[] nums) {

        if(list.size() == nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(check[i]) continue;
            check[i] = true;
            list.add(nums[i]);
            func(answer, list, check, nums);
            check[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        // 값 별로 인덱스를 저장해둔다.
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new HashSet<>());
            }
            map.get(nums[i]).add(i);
        }

        Set<String> sSet = new HashSet<>();

        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                int target = nums[i] + nums[j];
                if(map.containsKey(-target)){
                    int size = map.get(-target).size();
                    if(map.get(-target).contains(i)) size--;
                    if(map.get(-target).contains(j)) size--;

                    if(size >= 1){

                        // 정렬
                        int[] arr = {nums[i], nums[j], -target};
                        Arrays.sort(arr);
                        String temp = arr[0] + " " + arr[1] + " " + arr[2];
                        sSet.add(temp);
                    }
                }
            }
        }

        for(String str : sSet){
            String[] arr = str.split(" ");
            List<Integer> list = new ArrayList<>(Arrays.asList(
                Integer.parseInt(arr[0]),
                Integer.parseInt(arr[1]),
                Integer.parseInt(arr[2]))
                );

            answer.add(list);
        }

        return answer;
    }
}
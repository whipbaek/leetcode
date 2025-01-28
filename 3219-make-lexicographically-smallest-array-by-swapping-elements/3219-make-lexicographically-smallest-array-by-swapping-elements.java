import java.util.*;

class Solution {

    static class Node {
        public int idx;
        public int val;

        public Node (int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        List<Node> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(new Node(i, nums[i]));
        }

        list.sort((o1, o2) -> o1.val - o2.val);

        int groupNum = 0;
        Map<Integer, List<Node>> group = new HashMap<>();

        for(int i=0; i<list.size(); i++){
            if(i== 0){
                group.put(groupNum, new ArrayList<>());
                group.get(groupNum).add(new Node(list.get(i).idx, list.get(i).val));
                continue;
            }


            // limit 보다 크면 새로운 group 에 배정받는다.
            if(list.get(i).val - list.get(i-1).val > limit){
                groupNum++;
                group.put(groupNum, new ArrayList<>());
            }

            group.get(groupNum).add(new Node(list.get(i).idx, list.get(i).val));
        }

        int[] answer = new int[nums.length];

        // group 내에서 val값으로 sort한다.
        for(int i=0; i<=groupNum; i++){
            group.get(i).sort((o1, o2) -> o1.val - o2.val);
            List<Node> groupList = group.get(i);
            List<Integer> idxList = new ArrayList<>();
            
            for(Node node : groupList) {
                idxList.add(node.idx);
            }
            Collections.sort(idxList);

            for(int j=0; j<groupList.size(); j++){
                answer[idxList.get(j)] = groupList.get(j).val;
            }
        }

        return answer;
    }
}
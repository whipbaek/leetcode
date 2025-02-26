import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<len; i++){
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String res = new String(charArr);
            if(!map.containsKey(res)){
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(res, temp);
            } else{
                map.get(res).add(strs[i]);
            }
        }

        List<List<String>> answer = new ArrayList<>();

        for(String key : map.keySet()){
            answer.add(map.get(key));
        }

        return answer;
    }
}
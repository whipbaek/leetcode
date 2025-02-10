import java.util.*;

class Solution {
    public String reverseWords(String s) {
        String[] list = s.split(" ");
        List<String> values = new ArrayList<>();
        for(String st : list){
            if(!st.equals("")){
                values.add(st);
            }
        }

        StringBuilder sb = new StringBuilder("");
        for(int i=values.size()-1; i>=0; i--){
            sb.append(values.get(i));
            if(i != 0) sb.append(" ");
        }

        return sb.toString();
    }
}
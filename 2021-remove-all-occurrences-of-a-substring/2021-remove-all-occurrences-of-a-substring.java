import java.util.*;

class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while(true){
            int idx = sb.indexOf(part);
            if(idx == -1) break;
            sb.delete(idx, idx + part.length());
        }

        return sb.toString();
    }
}
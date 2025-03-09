import java.util.*;

class Solution {

    public int numTilePossibilities(String tiles) {

        Set<String> set = new HashSet<>();
        func(tiles, new StringBuilder(""), new boolean[tiles.length()], set);
        return set.size();
    }

    public void func(String tiles, StringBuilder sb, boolean[] check, Set<String> set) {

        // 최대길이가 넘어가면 pass
        if(sb.length() > tiles.length()) {
            return;
        }

        if(sb.length() != 0) {
            set.add(sb.toString());
        }

        // permutaion 을 만드는 과정에서 모든걸 다 set에 저장하면 되지 않는가?
        for(int i=0; i<tiles.length(); i++){
            if(check[i]) continue;
            check[i] = true;
            sb.append(tiles.charAt(i));
            func(tiles, sb, check, set);
            sb.deleteCharAt(sb.length() - 1);
            check[i] = false;
        }
    }

}
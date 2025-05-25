import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {

        Map<String, Integer> map = new HashMap<>();
        Map<String, Boolean> check = new HashMap<>();
        
        int answer = 0;
        int maxVal = 0;

        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            check.put(word, false);
        }

        for(String word : words) {
            if(check.get(word)) continue;
            System.out.println();
            check.put(word, true);

            // 자체적으로 팰린드롬인 경우
            if(isPalindrome(word)) {
                // 홀수인 경우 가장 긴 거를 찾고, 나머지는 계산해준다.
                if(map.get(word) % 2 == 1) {
                    maxVal = Math.max(maxVal, word.length());
                    if(map.get(word) > 2) {
                        answer += word.length() * (map.get(word) - 1);
                    }
                    continue;
                }

                answer += word.length() * (map.get(word));
                continue;
            }

            // 단어 자체가 팰린드롬이 아닌 경우, reverse 값이 있는지 확인한다.
            String re = new StringBuilder(word).reverse().toString();
            if(map.containsKey(re)) {
                check.put(re, true);
               int cnt = map.get(word) < map.get(re) ? map.get(word) : map.get(re);
               answer += (word.length() * 2 * cnt);
            } 
        }

        return answer + maxVal;
    }

    public boolean isPalindrome (String str) { 
        if(new StringBuilder(str).reverse().toString().equals(str)) return true;
        return false;
    }
}
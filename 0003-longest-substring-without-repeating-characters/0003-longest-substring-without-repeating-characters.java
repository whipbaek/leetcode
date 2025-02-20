import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();

        int front = 0;
        int rear = 0;
        int answer = 0;

        while(rear < s.length()){

            Character rearChar = s.charAt(rear);
            
            map.put(rearChar, map.getOrDefault(rearChar, 0) + 1); // rear 캐릭터 저장.
            
            if(map.get(rearChar) > 1){ // rear 의 캐릭터가 두개 이상일 경우 
                while(map.get(rearChar) > 1){
                    Character frontChar = s.charAt(front);
                    map.put(frontChar, map.get(frontChar) - 1);
                    front++;
                }
            } 

            // 갱신해준다.
            answer = Math.max(answer, rear - front);
            rear++; // pointer 이동
        }

        return answer + 1;
    }
}
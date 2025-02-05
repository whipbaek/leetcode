import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(i <= s.length() - 2){
                if(ch == 'I'){
                    if(s.charAt(i+1) == 'V') {
                        answer += 4;
                        i++;
                    } else if(s.charAt(i+1) == 'X'){
                        answer += 9;
                        i++;
                    } else{
                        answer += map.get(ch);
                    }
                }

                else if(ch == 'X'){
                    if(s.charAt(i+1) == 'L') {
                        answer += 40;
                        i++;
                    } else if(s.charAt(i+1) == 'C'){
                        answer += 90;
                        i++;
                    } else{
                        answer += map.get(ch);
                    }
                }

                else if(ch == 'C'){
                    if(s.charAt(i+1) == 'D') {
                        answer += 400;
                        i++;
                    } else if(s.charAt(i+1) == 'M'){
                        answer += 900;
                        i++;
                    } else{
                        answer += map.get(ch);
                    }
                } else{
                    answer += map.get(ch);
                }
            } else{
                answer += map.get(ch);
            }

            System.out.println(answer);
        }

        return answer;
    }
}
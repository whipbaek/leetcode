class Solution {
    public int numberOfSubstrings(String s) {
        int front = 0;
        int rear = -1;
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);

        while(true){
            if(possible(map)) {
                answer += (s.length() - rear);
                map.put(s.charAt(front), map.get(s.charAt(front)) - 1);
                front++;
            } else{
                rear++;
                if(rear >= s.length()) break;
                map.put(s.charAt(rear), map.getOrDefault(s.charAt(rear), 0) + 1);
            }
        }

        return answer;
    }

    public boolean possible(Map<Character, Integer> map) {
        return map.get('a') >= 1 && map.get('b') >= 1 && map.get('c') >= 1;
    }
}
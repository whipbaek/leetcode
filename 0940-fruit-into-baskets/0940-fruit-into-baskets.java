class Solution {
    static class Node {
        public int s;
        public int e;

        public Node (int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public int totalFruit(int[] fruits) {
        // if(fruites.length == 0) return 0;
        // if(fruites.length == 1) return 1;
        // if(fruites.length == 2) return 2;
        
        Map<Integer, Node> map = new HashMap<>();
        Integer answer = 0;
        for(int i=0; i<fruits.length; i++) {

            int val = fruits[i];

            if(map.size() < 2 && !map.containsKey(val)) {
                map.put(val, new Node(i, i));
                continue;
            } 

            // 포함하고 있으면 뒤에 index 만 갱신해준다.
            if(map.containsKey(val)) {
                map.get(val).e = i;
                continue;
            } 

            // 포함하고 있지 않는 경우에는 갱신이 필요하다.
            // 1. 가장 앞 index 와, 가장 뒤 index 의 거리로 값을 갱신한다.
            // 2. 뒤 index 가 더 빠른 숫자의 다음값을, 다른값의 첫번째 값으로 설정한다.
            // 3. 새로운 값을 map 에 넣고 index 갱신한다.
            
            Integer targetKey = -1;
            Integer anotherKey = -1;
            Integer front = Integer.MAX_VALUE;
            Integer back = -1;
            Integer targetIdx = Integer.MAX_VALUE;

            for(Integer key : map.keySet()) {
                
                if(map.get(key).s < front) front = map.get(key).s;
                if(map.get(key).e > back) back = map.get(key).e;

                // 두 키 중 가장 작은 값 선정
                if(map.get(key).e < targetIdx) {
                    targetKey = key;
                    targetIdx = map.get(key).e;
                    continue;
                }
            }
            // System.out.println("front : " + front + ", back : " + back );

            // 1. 값 갱신
            answer = Math.max(answer, (back - front) + 1);

            
            // 작은 키 값 삭제
            for(Integer key : map.keySet()) {
                if(key != targetKey) {
                    map.get(key).s = targetIdx + 1;
                }
            }

            map.remove(targetKey);

            // 새로운 키 등록
            map.put(val, new Node(i, i));
        }

        Integer front = Integer.MAX_VALUE;
        Integer back = -1;

        for(Integer key : map.keySet()) {
            
            if(map.get(key).s < front) front = map.get(key).s;
            if(map.get(key).e > back) back = map.get(key).e;
        }

        // System.out.println("front : " + front + ", back : " + back);

        // 1. 값 갱신
        answer = Math.max(answer, (back - front) + 1);

        return answer;
    }
}
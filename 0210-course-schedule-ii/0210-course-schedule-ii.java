class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        int[] inDegree = new int[numCourses];
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        // 초기 세팅
        for(int i=0; i<prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];

            if(!graph.containsKey(from)) {
                graph.put(from, new ArrayList<Integer>());
            }
            
            graph.get(from).add(to);
            inDegree[to]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int[] answer = new int[numCourses];
        Set<Integer> answerSet = new HashSet<>();
        int idx = 0;

        boolean possible = false;
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                possible = true;
                queue.addLast(i);
            }
        }

        // 0 인 차수들을 돌면서 없애준다.
        while(!queue.isEmpty()) {
            Integer target = queue.removeFirst();
            answer[idx++] = target;
            answerSet.add(target);
            if(!graph.containsKey(target)) continue;

            for(int val : graph.get(target)) {
                inDegree[val]--;

                if(inDegree[val] == 0) {
                    queue.addLast(val);
                }
            }
        }

        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] != 0) {
                return new int[0];
            }
        }


        for(int i=0; i<numCourses; i++) {
            if(!answerSet.contains(i)) {
                answer[idx++] = i;
            }
        }

        return answer;
    }
}
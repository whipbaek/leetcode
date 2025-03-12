class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 진입차수
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> targetSet = new HashSet<>();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            if(!inDegree.containsKey(a)) inDegree.put(a, 0);
            if(!inDegree.containsKey(b)) inDegree.put(b, 0);

            targetSet.add(a);
            targetSet.add(b);

            graph.get(b).add(a);
            inDegree.put(a, inDegree.get(a) + 1);
        }

        // 0 인 것들을 넣는다.
        for(Integer key : inDegree.keySet()) {
            if(inDegree.get(key) == 0) {
                queue.add(key); 
                visited.add(key);
            }
        }

        while(!queue.isEmpty()) {
            // 0개 인 값
            Integer idx = queue.removeFirst();
            visited.add(idx);

            // 해당 값에서 포함되는 inDegree - 1
            for(int i=0; i<graph.get(idx).size(); i++) {
                int target = graph.get(idx).get(i);
                inDegree.put(target, inDegree.get(target) - 1);

                if(inDegree.get(target) == 0) {
                    queue.addLast(target);
                }
            }
        }

        return visited.size() == targetSet.size();
    }
}
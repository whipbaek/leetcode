import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        // isConnected 가 그래프
        int n = isConnected[0].length;

        boolean[] visited = new boolean[n];
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                if(isConnected[i][j] == 0) continue;
                graph.get(i).add(j);
            }
        }

        //bfs
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                
                Deque<Integer> queue = new ArrayDeque<>();
                queue.addLast(i);

                while(!queue.isEmpty()) {
                    int target = queue.removeFirst();
                    visited[target] = true;

                    for(int val : graph.get(target)) {
                        if(!visited[val]) {
                            queue.addLast(val);
                        }
                    }   
                }
            }
        }

        return answer;
    }
}
import java.util.*;

class Solution {

    static class Node {
        public int num;
        public int val;

        public Node (int num, int val) {
            this.num = num;
            this.val = val;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        
        // weights[from][to] => from 에서 to 로 가는 "최소" 가중치
        int[][] weights = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<n+1; j++) {
                weights[i][j] = 100000000;
            }
        }
        weights[k][k] = 0; 

        // 가중치 설정
        for(int[] time :  times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];

            weights[from][to] = weight; 
        }

        // Node <노드번호, weights[k][노드번호]>
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        pq.add(new Node(k, 0));
        while(!pq.isEmpty()) {
            // 다음 방문할 노드 꺼내고, 방문 처리한다.
            Node target = pq.poll();
            if(visited[target.num]) continue;
            visited[target.num] = true;

            // 여기서 다른 노드로의 값들을 모두 갱신한다.
            for(int i=1; i <= n; i++) {
                weights[k][i] = 
                Math.min(weights[k][i], weights[k][target.num] + weights[target.num][i]);
                if(!visited[i] && weights[k][i] != 100000000) {
                    pq.add(new Node(i, weights[k][i]));
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(!visited[i]) return -1;
            answer = Math.max(answer, weights[k][i]);
        }

        return answer;
    }
}
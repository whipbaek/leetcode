import java.util.*;

/**
Union - Find?
 */

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[1001]; // 최대 노드 개수
        int[] answer = new int[2];
        for(int i=0; i<1001; i++) parent[i] = i;

        for(int[] edge : edges) {

            int n1P = find(parent, edge[0]);
            int n2P = find(parent, edge[1]);

            // 만약 두 부모가 다르다면, 작은쪽으로 연결해준다.
            if(n1P != n2P) {
                if(n1P < n2P) parent[n1P] = n2P;
                else parent[n2P] = n1P;
            } else{
                answer = new int[]{edge[0], edge[1]};
            }
        }
        return answer;
    }

    public int find(int[] parent, int n) {
        // 부모랑 n 이랑 같다면, 최종 목적지에 온것이다.
        if(parent[n] == n) {
            return n;
        }

        // 그게 아니라면, 부모를 찾아간다. 
        return parent[n] = find(parent, parent[n]);
    }
}
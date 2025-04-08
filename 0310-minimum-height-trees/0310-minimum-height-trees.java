class Solution {
    public static class Node {
        public int num;
        public int dis;

        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        // edge case
        if(n == 1) return new ArrayList<>(Arrays.asList(0));

        int[] degree = new int[n]; // 각 노드에 몇개의 간선이 있는지 체크한다.
        List<Set<Integer>> graph = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.dis - o1.dis);

        // graph Set 초기화
        for(int i=0; i<n; i++) graph.add(new HashSet<>());

        // Graph 초기화
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);    
        }

        // 간선 초기화
        for(int i=0; i<n; i++) degree[i] = graph.get(i).size();

        boolean[] visited = new boolean[n];

        // topo sort 를 위한 Queue -> 간선이 1개인 값들만 넣는다.
        Deque<Node> queue = new ArrayDeque<>(); 

        // 간선이 1개인 값들만 큐에 넣는다.
        for(int i=0; i<n; i++) {
            if(degree[i] == 1){ 
                queue.addLast(new Node(i, 0));
                pq.add(new Node(i, 0));
            }
        }

        while(!queue.isEmpty()) {
            Node node = queue.removeFirst();
            visited[node.num] = true; // 방문했다는 뜻.

            // 연결되어 있는 노드들의 간선을 제거하고, 1개인 노드들은 넣어준다.
            for(int val : graph.get(node.num)) {
                degree[val]--;
                if(degree[val] == 1 && !visited[val]) {
                    Node temp = new Node(val, node.dis + 1);
                    queue.addLast(temp);
                    pq.add(temp);
                }
            }
        }

        for(int val : answer) {
            System.out.print(val + " ");
        } System.out.println();

        int maxVal = pq.peek().dis;
        while(!pq.isEmpty() && pq.peek().dis == maxVal) {
            answer.add(pq.poll().num);
        }

        return answer;
    }
}
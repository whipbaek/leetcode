class Solution {

    static class Node {
        public int start;
        public int end;

        public Node (int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public int[][] merge(int[][] intervals) {
        // [1, 3], [2, 6], [8, 10], [15, 18]
        // 앞선 값 기준으로 정렬을 한다.
        // 뒤에 값이 다음값보다 더 크거나 같다면 뒤에값으로 갱신한다. 
        List<Node> ansList = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.start == o2.start) { // start 같은경우 end 기준으로 오름차순 정렬
                return o1.end - o2.end;
            }

            return o1.start - o2.start; // start 기준으로 오름차순 정렬
        });

        // pq setup
        for(int i=0; i<intervals.length; i++) {
            pq.add(new Node(intervals[i][0], intervals[i][1]));
        }
        Node node = pq.poll();
        while(!pq.isEmpty()) {
            Node target = pq.poll();
            // 현재 node 와 overlapping 이 되는경우
            if(node.end >= target.start) { 
                // overlapping 한다.
                node.end = node.end > target.end ? node.end : target.end;
                continue;
            }

            // 안된다면? 기존 Node 는 ansList 에 넣고, Node 를 target 으로 업데이트한다.
            ansList.add(new Node(node.start, node.end));
            node = target;
        }
        ansList.add(node);
        int[][] answer = new int[ansList.size()][2];

        for(int i=0; i<ansList.size(); i++) {
            answer[i][0] = ansList.get(i).start;
            answer[i][1] = ansList.get(i).end;
        }

        return answer;
    }
}
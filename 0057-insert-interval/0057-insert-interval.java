import java.util.*;

class Solution {

    static class Node {
        public int start;
        public int end;

        public Node (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {

        /*
        정렬 기준 : 앞 값을 기준으로 처리, 같으면 뒤가 더 큰 값으로 처리
        */
        List<Node> list = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.start == o2.start) { // start 가 같으면 end 가 큰 값으로
                return o2.end - o1.end;
            }

            return o1.start - o2.start; // 기본적으로 start 오름차순
        });

        pq.add(new Node(newInterval[0], newInterval[1]));

        for(int[] interval : intervals) {
            pq.add(new Node(interval[0], interval[1]));
        }

        // 작은값부터 꺼내서 뒤에값이 앞에값과 겹치면 merge 해준다.
        // 안겹치면 list 에 넣어준다.
        Node cn = pq.poll();
        while(!pq.isEmpty()) {
            Node tn = pq.poll();

            
            if(tn.start <= cn.end) { // 겹치는 경우
                if(cn.end < tn.end) {
                    cn.end = tn.end;
                }
            } else { // 겹치지 않는 경우
                list.add(new Node(cn.start, cn.end));
                cn = tn;
            }
        }
        list.add(cn);

        int[][] answer = new int[list.size()][2];

        for(int i=0; i<list.size(); i++) {
            answer[i][0] = list.get(i).start;
            answer[i][1] = list.get(i).end;
        }

        return answer;
    }
}
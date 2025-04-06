/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) { 

        if(node == null) {
            return null;
        }

        // bsf 시 사용
        Set<Integer> visited = new HashSet<>();
        Deque<Node> queue = new ArrayDeque<>();
        Map<Integer,Node> map = new HashMap<>();  // 복사본 노드를 저장하는 map

        // startNode 를 찾고, 생성한다.
        int startNumber = node.val;
        // startNode 의 복사본을 저장한다.
        map.put(startNumber, new Node(node.val, new ArrayList<>())); 
        // 실제 노드를 queue 에 담는다. 
        queue.addLast(node);

        while(!queue.isEmpty()) {
            Node targetNode = queue.removeFirst(); // 실제 노드
            if(visited.contains(targetNode.val)) continue; // 방문한 노드면 패스한다.
            visited.add(targetNode.val); // 방문 처리

            for(Node valNode : targetNode.neighbors) {
                // 만약 지금 탐색하는 노드 (valNode) 의 복사본 노드가 없을 경우, 새로 생성해줘야한다.
                Node copyNode;
                if(!map.containsKey(valNode.val)) {
                    copyNode = new Node(valNode.val, new ArrayList<>());
                    map.put(valNode.val, copyNode);
                } else {
                    copyNode = map.get(valNode.val);
                }
                // 복사본 기준 노드에, 복사 노드를 연결해준다.
                map.get(targetNode.val).neighbors.add(copyNode);
                queue.addLast(valNode);
            }

        }

        return map.get(startNumber);
    }
}
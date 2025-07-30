/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node, Integer> currentNodeMap = new HashMap<>();
        int count = 1;
        currentNodeMap.put(head, count++);
        Node current = head;
        Node next = current.next;

        // 각 노드들이 몇 번째에 위치해있는지 저장한다.
        while(next != null) {
            current = next;
            next = current.next;
            currentNodeMap.put(current, count++);
        }

        Map<Integer, Integer> currentSeqMap = new HashMap<>();
        current = head;
        next = current.next;
        count = 1;
        currentSeqMap.put(count++, currentNodeMap.get(current.random));
        // 각 노드들이 랜덤노드로 몇 번째 노드를 가지고 있는지 파악한다.
        while(next != null) {
            current = next;
            next = current.next;
            currentSeqMap.put(count++, currentNodeMap.get(current.random));
        }


        // 순서대로 copy 해서 linked list 를 생성한다.
        current = head;
        next = current.next;
        Node n_head = new Node(head.val);
        Node t = n_head;
        Map<Integer, Node> nextNodeMap = new HashMap<>();
        count = 1;
        nextNodeMap.put(count++, n_head);

        while(next != null) {
            current = next;
            next = current.next;
            Node temp = new Node(current.val);
            t.next = temp;
            t = t.next;
            nextNodeMap.put(count++, temp);
        }

        // 기존 리스트가 몇번 노드가 몇번을 가리키는지 참조해서 똑같이 구성한다.
        t = n_head;
        count = 1;
        Integer randomCount = -1;
        while(t != null) {
            randomCount = currentSeqMap.get(count++); // random node 순번
            t.random = nextNodeMap.get(randomCount);
            t = t.next;
        }
        
        return n_head;
    }
}
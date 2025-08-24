/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        // 예외처리
        if(left == right) return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode front = null;
        ListNode back = null;
        ListNode cur = head;
        int idx = 1;
        
        while(cur != null) {
            if(idx < left) front = cur;
            if(idx > right && back == null) back = cur;

            if(idx >= left && idx <= right) {
                stack.push(cur);
            }
            idx++;
            cur = cur.next;
        }

        // front 설정
        if(front == null) {
            front = stack.pop();
            head = front;
        } else{
            front.next = stack.pop();
            front = front.next;
        }

        while(!stack.isEmpty()) {
            front.next = stack.pop();
            front = front.next;     
        }
        if(back == null) front.next = null;
        if(back != null) front.next = back;

        return head;
    }
}
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aPointer = null;
        ListNode bPointer = null;

        // 각 노드에 대한 포인터 저장 (a, b)
        int cnt = 0;
        ListNode temp = list1;
        while(true) {
            if(cnt == a-1) aPointer = temp;
            if(cnt == b+1) bPointer = temp;
            if(aPointer != null && bPointer != null) break;

            cnt++;
            temp = temp.next;
        }
        aPointer.next = list2;
        
        // list2 의 끝 발견시 next 를 b 포인터로 연결한다.
        temp = list2;
        while(true) {
            if(temp.next == null) {
                temp.next = bPointer;
                break;
            }
            temp = temp.next;
        }
        
        return list1;
    }
}
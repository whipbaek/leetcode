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
import java.util.*;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int len = 0;
        if(head == null) return null;

        while(temp != null) {
            len++;
            temp = temp.next;
        }

        // 실제로 회전해야하는 횟수
        k %= len;

        // 회전안해도 되면 바로 return
        if(k==0) return head;
        k--;
        
        // 실제로 헤드가 될 곳의 순번
        int newHeadIdx = len-k;
        int currentIdx = 0;
        ListNode headAddrBackup = head; // head 백업

        temp = head;

        while(temp != null) {
            currentIdx++;

            // 1. 다음노드가 head 가 되어야할곳이면?
            //   1-1. 우선 temp Node 를 옮겨준다.
            //   1-2. 현재 노드의 next 는 null 로 선언한다.
            if(currentIdx + 1 == newHeadIdx) {
                ListNode nullNode = temp;
                temp = temp.next; // temp 이동
                head = temp; // head 세팅
                nullNode.next = null;
                continue;
            }

            // 2. 마지막 노드인경우에는?
            //   2-1. next Node 를 headAddrBackup 으로 선언해주고, Break 해준다.
            if(currentIdx == len) {
                temp.next = headAddrBackup;
                break;
            }

            temp = temp.next;
        }
    
        return head;
    }
}
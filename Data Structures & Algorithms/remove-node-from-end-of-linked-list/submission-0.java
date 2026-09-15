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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head, prev = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = temp;
        }

        ListNode reverse = prev;
        if (n == 1) {
            reverse = prev.next;
        } else {
            for (int i=1; i<n-1; i++) {
                prev = prev.next;
            }

            prev.next = prev.next != null ? prev.next.next : null;
        }

        cur = reverse; 
        ListNode prevn = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prevn;

            prevn = cur;
            cur = temp;
        }

        return prevn;
    }
}

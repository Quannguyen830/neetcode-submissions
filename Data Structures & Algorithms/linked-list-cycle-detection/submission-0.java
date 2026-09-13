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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            if (fast.val == slow.val) return true;
            
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}

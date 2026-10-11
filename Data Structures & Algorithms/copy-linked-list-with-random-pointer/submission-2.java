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
        if (head == null) return null;

        Node cur = head;

        while (cur != null) {
            Node node = new Node(cur.val);

            Node temp = cur.next;
            cur.next = node;
            node.next = temp;

            cur = temp;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node copyHead = cur.next;
        while (cur != null) {
            Node temp = cur.next.next;
            Node node = cur.next;
            node.next = temp == null ? null : temp.next;

            cur.next = temp;
            cur = cur.next;
        }

        return copyHead;
    }
}

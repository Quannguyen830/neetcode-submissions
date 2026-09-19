class LRUCache {

    static class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode prev;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final Map<Integer, ListNode> map = new HashMap<>();
    private int cap;
    private final ListNode head = new ListNode(0, 0);
    private final ListNode tail = new ListNode(0, 0);

    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        moveToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            moveToFront(map.get(key));
        } else {
            if (map.size() == cap) {
                evict();
            }
            ListNode node = new ListNode(key, value);
            addToRecent(node);
            map.put(key, node);
        }
    }

    private void moveToFront(ListNode node) {
        remove(node);
        addToRecent(node);
    }

    private void remove(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addToRecent(ListNode node) {
        ListNode temp = head.next;

        head.next = node;
        node.prev = head;

        node.next = temp;
        temp.prev = node;
    }

    private void evict() {
        ListNode temp = tail.prev, pre = tail.prev.prev;
        tail.prev = pre;
        pre.next = tail;

        map.remove(temp.key);
    }
}

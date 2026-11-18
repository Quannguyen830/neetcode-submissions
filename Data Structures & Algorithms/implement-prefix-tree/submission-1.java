class PrefixTree {
    class Node {
        Node[] nodes;
        boolean isEnd;

        Node() {
            nodes = new Node[26];
            isEnd = false;
        }
    }

    private Node head = new Node();

    public PrefixTree() {}

    public void insert(String word) {
        Node cur = head;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.nodes[index] == null) {
                cur.nodes[index] = new Node();
            }

            cur = cur.nodes[index];
        }

        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node cur = head;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.nodes[index] == null) {
                return false;
            }

            cur = cur.nodes[index];
        }

        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node cur = head;
        for (int i=0; i<prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.nodes[index] == null) {
                return false;
            }

            cur = cur.nodes[index];
        }

        return true;
    }
}

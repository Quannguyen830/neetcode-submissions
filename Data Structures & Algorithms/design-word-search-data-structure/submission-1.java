class WordDictionary {

    class Node {
        Node[] nodes;
        boolean isEnd;

        Node() {
            nodes = new Node[26];
            isEnd = false;
        }
    }

    private Node head = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node cur = head;
        for (int i=0; i<word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.nodes[c] == null) {
                cur.nodes[c] = new Node();
            }

            cur = cur.nodes[c];
        }

        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node cur = head;
        return dfs(word, cur, 0);
    }

    private boolean dfs(String word, Node cur, int index) {
        if (index == word.length()) {
            return cur.isEnd;
        }

        for (int i=index; i<word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j=0; j<26; j++) {
                    if (cur.nodes[j] != null) {
                        if(dfs(word, cur.nodes[j], i+1)) return true;
                    }
                }
                return false;
            } else {
                int c = word.charAt(i) - 'a';
                if (cur.nodes[c] == null) {
                    return false;
                }

                cur = cur.nodes[c];
            }
        }

        return cur.isEnd;
    }
}

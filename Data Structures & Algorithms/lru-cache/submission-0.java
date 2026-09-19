class LRUCache {

    private Map<Integer, Integer> map = new HashMap<>();
    private int cap;
    private Deque<Integer> queue = new ArrayDeque<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        queue.remove(key);
        queue.addLast(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
        } else if (map.size() == cap) {
            int lrkey = queue.removeFirst();
            map.remove(lrkey);
        } 
        
        queue.addLast(key);
        map.put(key, value);
    }
}

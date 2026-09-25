class KthLargest {

    private PriorityQueue<Integer> pq = new PriorityQueue<>();

    private int k;

    public KthLargest(int k, int[] nums) {
        for (int i=0; i<nums.length; i++) {
            add(nums[i]);
        }
        this.k = k;
    }
    
    public int add(int val) {
        if (pq.size() >= k) {
            pq.poll();
        }
        pq.offer(val);
        return pq.peek();
    }
}

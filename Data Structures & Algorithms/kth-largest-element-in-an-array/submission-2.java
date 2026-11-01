class Solution {
    public int findKthLargest(int[] nums, int k) {
        // same shit

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num: nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}

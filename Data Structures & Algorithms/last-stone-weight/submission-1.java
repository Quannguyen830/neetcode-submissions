class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int heaviest = pq.poll();
            int second = pq.poll();

            int diff = heaviest - second;
            if (diff > 0) {
                pq.offer(diff);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}

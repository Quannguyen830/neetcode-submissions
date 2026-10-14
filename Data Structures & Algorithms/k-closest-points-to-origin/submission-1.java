class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(distance(b), distance(a))
        );

        for (int[] point: points) {
            pq.offer(point);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i=0; i<k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    private long distance(int[] array) {
        int x = array[0];
        int y = array[1];
        return x*x + y*y;
    }
}

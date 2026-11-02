class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Long.compare(distance(b), distance(a))
        );
        int[][] result = new int[k][2];

        for (int[] point: points) {
            maxHeap.add(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        for (int i=0; i<k; i++) {
            int[] point = maxHeap.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
        }

        return result;
    }

    private long distance(int[] array) {
        int x = array[0];
        int y = array[1];
        return x*x + y*y;
    }
}

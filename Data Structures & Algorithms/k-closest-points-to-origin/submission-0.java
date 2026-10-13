class Solution {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        double distToOrigin;

        Point(int x, int y, double d) {
            this.x = x;
            this.y = y;
            this.distToOrigin = d;
        }

        @Override
        public int compareTo(Point other) {
            return Double.compare(this.distToOrigin, other.distToOrigin);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int[] point: points) {
            int x = point[0];
            int y = point[1];

            double dist = Math.sqrt((x*x) + (y*y));
            pq.offer(new Point(x, y, dist));
        }

        int[][] result = new int[k][2];
        for (int i=0; i<k; i++) {
            Point point = pq.poll();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }

        return result;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int size = position.length;

        int[][] cars = new int[size][2];
        for (int i=0; i<size; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        double[] time = new double[size];
        Deque<Double> stack = new ArrayDeque<>();

        for (int i=0; i<size; i++) {
            time[i] = (double) (target - cars[i][0]) / cars[i][1];
        }

        for (int i=0; i<size; i++) {
            if (stack.isEmpty() || time[i] > stack.peekFirst()) {
                stack.addFirst(time[i]);
            }
        }

        return stack.size();
    }
}

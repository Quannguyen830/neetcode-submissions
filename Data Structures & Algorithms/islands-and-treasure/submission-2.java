class Solution {
    private int[] directionX = {1, -1, 0, 0};
    private int[] directionY = {0, 0, 1, -1};

    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    queue.addLast(new int[] {r, c});
                }
            }
        }

        int distance = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            distance++;

            for (int i = 0; i < levelSize; i++) {
                int[] cur = queue.pollFirst();

                for (int j = 0; j < 4; j++) {
                    int newR = cur[0] + directionX[j];
                    int newC = cur[1] + directionY[j];

                    if (newR >= grid.length || newR < 0 || newC >= grid[0].length || newC < 0 || grid[newR][newC] == -1 || grid[newR][newC] != Integer.MAX_VALUE)
                        continue;

                    queue.addLast(new int[] {newR, newC});
                    grid[newR][newC] = distance;
                }
            }
        }
    }
}

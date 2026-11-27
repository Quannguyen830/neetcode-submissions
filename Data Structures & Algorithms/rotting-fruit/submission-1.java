class Solution {
    public int orangesRotting(int[][] grid) {
        int result = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        int[] directionX = {1, -1, 0, 0};
        int[] directionY = {0, 0, 1, -1};

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.addLast(new int[] {r, c});
                }
            }
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int[] cur = queue.pollFirst();

                for (int j = 0; j < 4; j++) {
                    int newR = cur[0] + directionX[j];
                    int newC = cur[1] + directionY[j];

                    if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length
                        || grid[newR][newC] != 1) {
                        continue;
                    }

                    queue.addLast(new int[] {newR, newC});
                    grid[newR][newC] = 2;
                }
            }

            result++;
        }

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return result - 1;
    }
}

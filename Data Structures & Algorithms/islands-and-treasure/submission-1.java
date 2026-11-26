class Solution {
    private int[] directionX = {1, -1, 0, 0};
    private int[] directionY = {0, 0, 1, -1};

    public void islandsAndTreasure(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] != -1 && grid[r][c] != 0) {
                    grid[r][c] = bfs(grid, new int[] {r, c});
                }
            }
        }
    }

    private int bfs(int[][] grid, int[] start) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Deque<int[]> queue = new ArrayDeque<>();
        int result = 1;

        int r = start[0], c = start[1];

        visited[r][c] = true;
        queue.addLast(start);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int j = 0; j < levelSize; j++) {
                int[] cur = queue.pollFirst();

                for (int i = 0; i < 4; i++) {
                    int newR = cur[0] + directionX[i];
                    int newC = cur[1] + directionY[i];

                    if (newR >= grid.length || newR < 0 || newC >= grid[0].length || newC < 0
                        || visited[newR][newC] || grid[newR][newC] == -1)
                        continue;

                    if (grid[newR][newC] == 0) {
                        return result;
                    }

                    queue.addLast(new int[] {newR, newC});
                    visited[newR][newC] = true;
                }
            }

            result++;
        }

        return Integer.MAX_VALUE;
    }
}

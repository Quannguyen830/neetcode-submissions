class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;

        int rLimit = grid.length;
        int cLimit = grid[0].length;
        boolean[][] visited = new boolean[rLimit][cLimit];

        for (int r = 0; r < rLimit; r++) {
            for (int c = 0; c < cLimit; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    bfs(r, c, grid, visited, rLimit, cLimit);
                    result++;
                }
            }
        }

        return result;
    }

    private void bfs(
        int r, int c, char[][] grid, boolean[][] visited, int rLimit, int cLimit) {
        int[] directionX = {1, -1, 0, 0};
        int[] directionY = {0, 0, 1, -1};

        int[] point = {r, c};
        Deque<int[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.addLast(point);

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + directionX[i];
                int newY = cur[1] + directionY[i];

                if (newX < 0 || newX >= rLimit || newY < 0 || newY >= cLimit) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (grid[newX][newY] == '0') {
                    continue;
                }

                int[] newPoint = {newX, newY};
                queue.addLast(newPoint);
                visited[newX][newY] = true;
            }
        }
    }
}

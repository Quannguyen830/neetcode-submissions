class Solution {
    private int[] directionX = {1, -1, 0, 0};
    private int[] directionY = {0, 0, 1, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[r].length; c++) {
                if (!visited[r][c] && grid[r][c] == 1) {
                    max = Math.max(max, bfs(r, c, grid, visited, grid[r].length));
                }
            }
        }

        return max;
    }

    private int bfs(int r, int c, int[][] grid, boolean[][] visited, int cols) {
        Deque<Integer> queue = new ArrayDeque<>();
        int id = r * cols + c;
        queue.addLast(id);
        visited[r][c] = true;

        int size = 1;

        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            int curR = cur/cols;
            int curC = cur%cols;

            for (int i=0; i<4; i++) {
                int newR = curR + directionX[i];
                int newC = curC + directionY[i];

                if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[newR].length) {
                    continue;
                }

                if (visited[newR][newC]) {
                    continue;
                }

                if (grid[newR][newC] == 0) {
                    continue;
                }

                id = newR * cols + newC;
                queue.addLast(id);
                visited[newR][newC] = true;
                size++;
            }
        }

        return size;
    }
}

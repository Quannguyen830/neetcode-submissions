class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[r].length; c++) {
                if (!visited[r][c] && grid[r][c] == 1) {
                    max = Math.max(max, bfs(r, c, grid, visited));
                }
            }
        }

        return max;
    }

    private int bfs(int r, int c, int[][] grid, boolean[][] visited) {
        int[] directionX = {1, -1, 0, 0};
        int[] directionY = {0, 0, 1, -1};

        Deque<int[]> queue = new ArrayDeque<>();
        int[] point = {r, c};
        queue.addLast(point);
        visited[r][c] = true;

        int size = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();

            for (int i=0; i<4; i++) {
                int newR = cur[0] + directionX[i];
                int newC = cur[1] + directionY[i];

                if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[newR].length) {
                    continue;
                }

                if (visited[newR][newC]) {
                    continue;
                }

                if (grid[newR][newC] == 0) {
                    continue;
                }

                int[] newPoint = {newR, newC};
                queue.addLast(newPoint);
                visited[newR][newC] = true;
                size++;
            }
        }

        return size;
    }
}

class Solution {
    private int[] directionX = {1, -1, 0, 0};
    private int[] directionY = {0, 0, 1, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (!visited[r][c] && grid[r][c] == 1) {
                    max = Math.max(max, dfs(r, c, grid, visited, rows, cols));
                }
            }
        }

        return max;
    }

    private int dfs(int r, int c, int[][] grid, boolean[][] visited, int rows, int cols) {
        if (
            (r >= rows || r < 0 || c >= cols || c < 0)
            || visited[r][c] || grid[r][c] == 0
        ) {
            return 0;
        }

        int result = 1;
        visited[r][c] = true;        

        for (int i=0; i<4; i++) {
            result += dfs(r + directionX[i], c + directionY[i], grid, visited, rows, cols);
        }

        return result;
    }
}

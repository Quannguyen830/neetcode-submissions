class Solution {
    int[] directionX = {1, -1, 0, 0};
    int[] directionY = {0, 0, 1, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        Deque<int[]> atlanticQueue = new ArrayDeque<>();
        Deque<int[]> pacificQueue = new ArrayDeque<>();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] visitedAtlantic = new boolean[rows][cols];
        boolean[][] visitedPacific = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            pacificQueue.addLast(new int[] {r, 0});
            visitedPacific[r][0] = true;

            atlanticQueue.addLast(new int[] {r, cols - 1});
            visitedAtlantic[r][cols-1] = true;
        }

        for (int c = 0; c < cols; c++) {
            pacificQueue.addLast(new int[] {0, c});
            visitedPacific[0][c] = true;

            atlanticQueue.addLast(new int[] {rows - 1, c});
            visitedAtlantic[rows-1][c] = true;
        }

        bfs(heights, visitedPacific, pacificQueue, rows, cols);
        bfs(heights, visitedAtlantic, atlanticQueue, rows, cols);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (visitedPacific[r][c] && visitedAtlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(
        int[][] heights, boolean[][] visited, Deque<int[]> queue, int rows, int cols) {
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int curR = cur[0];
            int curC = cur[1];

            for (int i = 0; i < 4; i++) {
                int newR = curR + directionX[i];
                int newC = curC + directionY[i];

                if (newR < 0 || newC < 0 || newR >= rows || newC >= cols
                    || heights[newR][newC] < heights[curR][curC] || visited[newR][newC]) {
                    continue;
                }

                queue.addLast(new int[] {newR, newC});
                visited[newR][newC] = true;
            }
        }
    }
}

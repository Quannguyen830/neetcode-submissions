class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        Deque<int[]> alanticQueue = new ArrayDeque<>();
        Deque<int[]> pacificQueue = new ArrayDeque<>();

        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] visitedAlantic = new boolean[rows][cols];
        boolean[][] visitedPacific = new boolean[rows][cols];

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (r == 0 || c == 0) {
                    pacificQueue.addLast(new int[]{r, c});
                    visitedPacific[r][c] = true;
                } 
                
                if (r == rows-1 || c == cols-1) {
                    alanticQueue.addLast(new int[]{r, c});
                    visitedAlantic[r][c] = true;
                }
            }
        }

        int[] directionX = {1, -1, 0, 0};
        int[] directionY = {0, 0, 1, -1};

        while (!pacificQueue.isEmpty()) {
            int[] cur = pacificQueue.pollFirst();
            int curR = cur[0];
            int curC = cur[1];

            for (int i=0; i<4; i++) {
                int newR = curR + directionX[i];
                int newC = curC + directionY[i];

                if (
                    newR < 0 || newC < 0 || newR >= rows || newC >= cols
                    || heights[newR][newC] < heights[curR][curC] 
                    || visitedPacific[newR][newC]
                ) {
                    continue;
                }

                pacificQueue.addLast(new int[]{newR, newC});
                visitedPacific[newR][newC] = true;
            }
        }

        while (!alanticQueue.isEmpty()) {
            int[] cur = alanticQueue.pollFirst();
            int curR = cur[0];
            int curC = cur[1];

            for (int i=0; i<4; i++) {
                int newR = curR + directionX[i];
                int newC = curC + directionY[i];

                if (
                    newR < 0 || newC < 0 || newR >= rows || newC >= cols
                    || heights[newR][newC] < heights[curR][curC]
                    || visitedAlantic[newR][newC]
                ) {
                    continue;
                }

                alanticQueue.addLast(new int[]{newR, newC});
                visitedAlantic[newR][newC] = true;
            }
        }

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (visitedPacific[r][c] && visitedAlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.')
                    continue;

                char num = board[r][c];
                String squareKey = (r/3) + ";" + (c/3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(num)
                    || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(num)
                    || squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(num)) {
                    return false;
                }

                rows.get(r).add(num);
                cols.get(c).add(num);
                squares.get(squareKey).add(num);
            }
        }

        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int l = board.length;
        boolean[][] rows = new boolean[l][l];
        boolean[][] cols = new boolean[l][l];
        boolean[][] squares = new boolean[l][l];

        for (int r = 0; r < l; r++) {
            for (int c = 0; c < l; c++) {
                if (board[r][c] == '.')
                    continue;

                char num = board[r][c];
                int key = num - '1';
                int boxKey = (r/3) * 3 + (c/3);

                if (rows[r][key]
                    || cols[c][key]
                    || squares[boxKey][key]) {
                    return false;
                }

                rows[r][key] = true;
                cols[c][key] = true;
                squares[boxKey][key] = true;
            }
        }

        return true;
    }
}

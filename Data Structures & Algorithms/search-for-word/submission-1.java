class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[r].length; c++) {
                boolean found = dfs(board, word, r, c, 0);
                if (found) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        if (board[r][c] != word.charAt(i)) {
            return false;
        } else if (i == word.length() - 1) {
            return true;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        if (r > 0) {
            boolean up = dfs(board, word, r-1, c, i+1);
            if (up) return true;
        }

        if (r < board.length-1) {
            boolean down = dfs(board, word, r+1, c, i+1);
            if (down) return true;
        }

        if (c > 0) {
            boolean left = dfs(board, word, r, c-1, i+1);
            if (left) return true;
        }

        if (c < board[0].length-1) {
            boolean right = dfs(board, word, r, c+1, i+1);
            if (right) return true;
        }

        board[r][c] = temp;
        return false;
    }
}

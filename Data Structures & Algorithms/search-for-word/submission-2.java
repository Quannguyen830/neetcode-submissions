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

        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length) {
            return false;
        }

        if (board[r][c] != word.charAt(i)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = dfs(board, word, r+1, c, i+1) || dfs(board, word, r-1, c, i+1) || dfs(board, word, r, c+1, i+1) || dfs(board, word, r, c-1, i+1);
        board[r][c] = temp;
        return found;
    }
}

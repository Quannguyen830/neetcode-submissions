class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> rows = new HashMap<>();
        HashMap<Integer, Set<Character>> columns = new HashMap<>();
        HashMap<String, Set<Character>> squares= new HashMap<>();

        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board.length; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = (r/3) + "," + (c/3);

                char target = board[r][c];

                if (
                    rows.computeIfAbsent(r, k -> new HashSet<>()).contains(target) ||
                    columns.computeIfAbsent(c, k -> new HashSet<>()).contains(target) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(target)
                ) {
                    return false;
                }

                rows.get(r).add(target);
                columns.get(c).add(target);
                squares.get(squareKey).add(target);
            }
        }

        return true;
    }
}

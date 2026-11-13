class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, result, "", 0, 0);
        return result;
    }

    private void backtrack(int n, List<String> result, String current, int open, int close) {
        if (current.length() == 2*n) {
            result.add(current);
            return;
        }

        if (open < n) {
            backtrack(n, result, current + "(", open+1, close);        
        }

        if (close < open) {
            backtrack(n, result, current + ")", open, close+1);
        }
    }
}

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(String s, List<List<String>> result, List<String> cur, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i=start+1; i<=s.length(); i++) {
            if (!isPalindrome(s, start, i-1)) {
                continue;
            }
            cur.add(s.substring(start, i));
            backtrack(s, result, cur, i);
            cur.remove(cur.size()-1);
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}

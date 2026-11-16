class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        List<char[]> source = new ArrayList<>();
        source.add(new char[]{});                     // 0
        source.add(new char[]{});                     // 1
        source.add("abc".toCharArray());              // 2
        source.add("def".toCharArray());              // 3
        source.add("ghi".toCharArray());              // 4
        source.add("jkl".toCharArray());              // 5
        source.add("mno".toCharArray());              // 6
        source.add("pqrs".toCharArray());             // 7
        source.add("tuv".toCharArray());              // 8
        source.add("wxyz".toCharArray());             // 9

        backtrack(digits, result, source, "", 0);
        return result;    
    }

    private void backtrack(String digits, List<String> result, List<char[]> source, String cur, int index) {
        if (index == digits.length()) {
            result.add(cur);
            return;
        }

        char[] letters = source.get(digits.charAt(index) - '0');

        for (int i=0; i<letters.length; i++) {
            backtrack(digits, result, source, cur + letters[i], index+1);
        }
    }
}

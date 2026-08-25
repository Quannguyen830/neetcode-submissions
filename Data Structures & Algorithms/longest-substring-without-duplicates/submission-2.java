class Solution {
    public int lengthOfLongestSubstring(String s) {
        // l, r
        // while r < s.size
        //     if l != r l++
        //     else r++

        int l = 0, r = 0, max = 0;
        Set<Character> chars = new HashSet<>();

        while(r < s.length()) {
            if (chars.contains(s.charAt(r))) {
                chars.remove(s.charAt(l));
                l++;
            } else {
                chars.add(s.charAt(r));
                max = Math.max(r-l+1, max);
                r++;
            }
        }

        return max;
    }
}

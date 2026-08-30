class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, max = 0;
        Set<Character> chars = new HashSet<>();

        for (int r=0; r < s.length(); r++) {
            while (chars.contains(s.charAt(r))) {
                chars.remove(s.charAt(l));
                l++;
            }

            chars.add(s.charAt(r));
            max = Math.max(max, r-l+1);
        }
        
        return max;
    }
}

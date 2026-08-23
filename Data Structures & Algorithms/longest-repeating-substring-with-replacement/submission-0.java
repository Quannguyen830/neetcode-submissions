class Solution {
    public int characterReplacement(String s, int k) {
        // Here is my code for Longest Repeating Character Replacement.
        // Pattern: First idea is to use Sliding Window since an exercise
            // that requires find substring is a typical Sliding Window 
            // problem. 
        // Data Structure:  
        // Core Challenge: Main problem would be the replacement place and
            // how to know if that is the longest

        // XYYX

        int res = 0;
        int left = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right=0; right<s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));

            while ((right - left + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }

            res = Math.max(res, (right-left+1));
        }

        return res;
    }
}

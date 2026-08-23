class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Here is my code for Longest Substring Without Repeating Characters. 
        // Pattern: Sliding window since it helps keeping the current longest
            // string. The "window" (everything between your left and right pointers) 
            // simply represents your current valid state—a substring with 
            // zero duplicates. 
        // Data Structure: HashSet since we still need to find duplicates
        // Core Challenge: How to use two pointers effectively

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int right = 0; right<s.length(); right++) {
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar) && left <= map.get(currentChar)) {
                left = map.get(currentChar)+1;
            }

            map.put(currentChar, right);
            max = Math.max(max, right-left+1);
        }

        return max;
    }
}

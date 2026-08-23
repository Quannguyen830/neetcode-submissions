class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Here is my code for Permutation in String. 
        // Pattern: Finding a substring is typical sliding window. 
            // To find the substring of s1 in s2, store letter and then
            // find contains. 
        // Data Structure: HashMap<Character, Integer>
        // Core Challenge: How to know a HashMap is all back to 0

        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (char c: s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int left = 0;
        for (int right=0; right<s2.length(); right++) {
            windowCount[s2.charAt(right) - 'a']++;

            if ((right - left + 1) > s1.length()) {
                windowCount[s2.charAt(left) - 'a']--;
                left++;
            }

            if ((right - left + 1) == s1.length()) {
                if (Arrays.equals(windowCount, s1Count)) return true;
            }
        }

        return false;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Here is my code for Permutation in String. 
        // Pattern: Finding a substring is typical sliding window. 
            // To find the substring of s1 in s2, store letter and then
            // find contains. 
        // Data Structure: int array
        // Core Challenge: how to maintain the count of window and count
            // of frequency for s1

        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i=0; i<s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i=0; i<s1Count.length; i++) {
            if (s1Count[i] == s2Count[i]) matches += 1;
        }

        int left = 0;
        for (int right=s1.length(); right<s2.length(); right++) {
            if (matches == 26) return true;

            int index = s2.charAt(right) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index]) {
                matches += 1;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches -= 1;
            }

            index = s2.charAt(left) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches += 1;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches -= 1;
            }

            left++;
        }

        return matches == 26;
    }
}

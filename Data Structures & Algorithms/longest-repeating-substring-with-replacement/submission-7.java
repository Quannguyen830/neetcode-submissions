class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, max = 0, mostFreq = 0;
        char[] chars = new char[26];

        for (int r=0; r<s.length(); r++) {
            int index = s.charAt(r)-'A';

            chars[index]++;
            mostFreq = Math.max(mostFreq, chars[index]);

            while ((r-l+1) - mostFreq > k) {
                chars[s.charAt(l)-'A']--;
                l++;
            }

            max = Math.max(max, r-l+1);
        }

        return max;
    }
}

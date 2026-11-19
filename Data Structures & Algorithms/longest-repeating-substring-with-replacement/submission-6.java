class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0, l = 0, max = 0, mostFreq = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int r=0; r<s.length(); r++) {
            char c = s.charAt(r);

            freq.put(c, freq.getOrDefault(c, 0)+1);
            mostFreq = Math.max(mostFreq, freq.get(c));

            while ((r-l+1) - mostFreq > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l))-1);
                l++;
            }

            max = Math.max(max, r-l+1);
        }

        return max;
    }
}

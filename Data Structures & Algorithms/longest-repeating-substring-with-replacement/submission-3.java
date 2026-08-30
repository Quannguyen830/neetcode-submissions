class Solution {
    public int characterReplacement(String s, int k) {
        int mostFrequent = 0, l = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            mostFrequent = Math.max(mostFrequent, map.get(s.charAt(r)));

            while ((r - l + 1) - mostFrequent > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            max = Math.max(r - l + 1, max);
        }

        return max;
    }
}

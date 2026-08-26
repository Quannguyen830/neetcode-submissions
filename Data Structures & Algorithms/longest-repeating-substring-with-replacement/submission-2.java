class Solution {
    public int characterReplacement(String s, int k) {        
        int l = 0;
        int mostFrequent = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int r=0; r<s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            mostFrequent = Math.max(mostFrequent, map.get(c));

            while ((r-l+1) - mostFrequent > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;
            }

            result = Math.max(result, r-l+1);
        }

        return result;
    }
}

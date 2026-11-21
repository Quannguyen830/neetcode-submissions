class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Letters = new int[26];
        int[] s2Letters = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Letters[s1.charAt(i) - 'a']++;
            s2Letters[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Letters[i] == s2Letters[i])
                matches++;
        }

        if (matches == 26) {
            return true;
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26)
                return true;

            int index = s2.charAt(r) - 'a';
            s2Letters[index]++;
            if (s2Letters[index] == s1Letters[index]) {
                matches++;
            } else if (s2Letters[index] == s1Letters[index] + 1) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2Letters[index]--;
            if (s2Letters[index] == s1Letters[index]) {
                matches++;
            } else if (s2Letters[index] == s1Letters[index] - 1) {
                matches--;
            }

            l++;
        }

        return matches == 26;
    }
}

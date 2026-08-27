class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // int[] freq
        // int matches

        // for c in s1:
        //     freq.add(c)

        // l, r
        // while r < s2.length
        //     if r-l+1 > s1.length
        //         freq.remove(lc);
        //         l++;
        //     else 
        //         if rc is not in freq
        //             continue;
        //         else
        //             matches++
        //             if matches == s1.length return true
        //             freq.add(rc);
        //             r++;

        // return false;

        if (s1.length() > s2.length()) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i=0; i<s1.length(); i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i=0; i<26; i++) {
            if (need[i] == window[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r=s1.length(); r<s2.length(); r++) {
            if (matches == 26) return true;

            int ri = s2.charAt(r) - 'a';
            window[ri]++;

            if (window[ri] == need[ri]) {
                matches++;
            } else if (window[ri] == need[ri] + 1) {
                matches--;
            }

            int removed = s2.charAt(l) - 'a';
            window[removed]--;
            if (window[removed] == need[removed]) {
                matches++;
            } else if (window[removed] == need[removed] - 1) {
                matches--;
            }

            l++;
        }

        return matches == 26;
    }
}

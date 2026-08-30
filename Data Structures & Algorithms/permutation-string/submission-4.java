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

        int[] needs = new int[26];
        int[] current = new int[26];

        for (int i=0; i<s1.length(); i++) {
            needs[s1.charAt(i) - 'a']++;
            current[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i=0; i<26; i++) {
            if (needs[i] == current[i]) matches++;
        }

        int l = 0;
        for (int r=s1.length(); r<s2.length(); r++) {
            if (matches == 26) break;

            int indexr = s2.charAt(r) - 'a';
            current[indexr]++;
            if (current[indexr] == needs[indexr]) {
                matches++;
            } else if (current[indexr] == needs[indexr] + 1) {
                matches--;
            }

            int indexl = s2.charAt(l) - 'a';
            current[indexl]--;
            if (current[indexl] == needs[indexl]) {
                matches++;
            } else if (current[indexl] == needs[indexl] - 1) {
                matches--;
            }

            l++;
        }

        return matches == 26;
    }
}

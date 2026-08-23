class Solution {
    public boolean isAnagram(String s, String t) {
        // Here is my code for Valid Anagram. 
        // Pattern: Still a kind of finding duplicates but instead of 1 
            // string, we have to do it with 2 string. First idea is to 
            // add first string character to a HashMap<char, number of existence>
            // then count it down for second string. 
            // But since character has a contrainst of only 26 value. What we can 
            // do is using a array of number of existence (26 value), then count
            // up for first string and down for second. If any value is not 0,
            // then the number of existence between those 2 are not the same.
        // Data Structure: HashMap -> O(n) space, int[] -> O(1) space
        // Core Challenge: Java has significant memory overhead for wrapper 
            // classes. Using a HashMap<Character, Integer> forces Java to 
            // autobox every primitive char and int into Character and Integer 
            // objects. This creates unnecessary heap allocations and 
            // garbage collection overhead.
            // In an interview, when you hear the constraint 
            // "lowercase English letters," that is your Trigger to immediately 
            // drop the HashMap and use an array.

        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c: t.toCharArray()) {
            if (map.get(c) == null) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }

        return true;
    }
}

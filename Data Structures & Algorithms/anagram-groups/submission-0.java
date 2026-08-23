class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Here is my code for Group Anagrams. 
        // Pattern: Apply the same logic for Valid Anagram (O(n) time).
            // But since this is more than just 2 string comparing, we
            // need to store them in a HashMap. HashMap because it holds
            // the string and its similar anagrams, also since we need
            // to find the correct string inside so apply all instead of 
            // O(n3), we have O(n2) because lookup is O(1)
        // Data Structure: HashMap
        // Core Challenge: How to convert from Valid Anagram

        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            int[] tempArray = new int[26];

            for (char c: str.toCharArray()) {
                tempArray[c - 'a']++;
            }

            String tempStr = Arrays.toString(tempArray);

            if (map.containsKey(tempStr)) {
                map.get(tempStr).add(str);
            } else {
                List<String> listOfString = new ArrayList<>();
                listOfString.add(str);
                map.put(tempStr, listOfString);
            }
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }
}

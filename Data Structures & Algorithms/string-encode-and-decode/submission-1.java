class Solution {

    // Here is my code for Encode and Decode Strings. 
    // Pattern: Use patter "lengthOfString$string" for encoding.
        // Easy to decode when knowing the length to handle.
    // Data Structure: String
    // Core Challenge: How to distiguish the value between
        // string content and seperator.

    public String encode(List<String> strs) {
        // StringBuilder sb
        // for strs
            // prefix sum - length$str
            // sb.add(str.length + "$" + str)
        // return sb.toString

        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // int counter = 0;
        // while counter < str.length
            // if (str.charAt(counter) != "$") skip
            // int length = str.charAt(counter-1);
            // int nextWordStartAt = counter+length;
            // String str;
            // while counter < nextWor
                // str.add(strCharAt(counter++));
        
        List<String> result = new ArrayList<>();
        int counter = 0;
        while (counter < str.length()) {
            int pointer = counter;

            while (str.charAt(pointer) != '#') {
                pointer++;
            }

            int length = Integer.parseInt(str.substring(counter, pointer));

            counter = pointer+1;
            pointer = counter+length;

            result.add(str.substring(counter, pointer));

            counter = pointer;
        }

        return result;
    }
}

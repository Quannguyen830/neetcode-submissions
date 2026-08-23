class Solution {
    public int longestConsecutive(int[] nums) {
        // Here is my code for Longest Consecutive Sequence. 
        // Pattern: First idea is using sort and sliding window.
            // But that is O(nlogn), not very ideal. Can use 
            // HashSet to lookup +1 number but needs to find
            // the start of a valid sequence first.
        // Data Structure: HashSet
        // Core Challenge: How to find valid start of a sequence

        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        int max = 0;

        for (int num: set) {
            if (!set.contains(num-1)) {
                int length = 1;

                while (set.contains(num + length)) {
                    length++;
                }

                max = Math.max(max, length);
            }
        }

        return max;
    }
}

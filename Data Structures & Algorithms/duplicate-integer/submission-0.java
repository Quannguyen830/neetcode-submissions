class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Here is my code for Contains Duplicates.
        // Pattern: Notify duplicates. This is a classic problem for Hash function. 
            // Because this is a lookup problem, Hash function will search the target
            // in O(1) instead of O(1). So the problem comes from brute force O(n2)
            // to O(n)
        // Data Structure: Since this is only finding duplicates and no second value
            // needs to be stored so HashSet not HashMap.
        // Core Challenge: Find the correct data structure.

        HashSet<Integer> setOfNums = new HashSet<>();

        for (int num: nums) {
            if (!setOfNums.add(num)) {
                return true;
            }
        }

        return false;
    }
}
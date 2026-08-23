class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Here is my code for Products of Array Except Self. 
        // Pattern: First intention is using brute fore.
            // Haven't think of how to optimize it yet.
        // Data Structure: 
        // Core Challenge: How to know other numbers in
            // the array without using another nested loop

        int[] result = new int[nums.length];

        result[0] = 1;

        for (int i=1; i<nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        int postFix = 1;
        for (int i=nums.length-1; i>=0; i--) {
            result[i] *= postFix;
            postFix *= nums[i];
        }

        return result;
    }
}  
 
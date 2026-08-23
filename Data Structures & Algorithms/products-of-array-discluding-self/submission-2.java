class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Here is my code for Products of Array Except Self. 
        // Pattern: First intention is using brute fore.
            // Haven't think of how to optimize it yet.
        // Data Structure: 
        // Core Challenge: How to know other numbers in
            // the array without using another nested loop

        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 1;
        suffix[nums.length-1] = 1;

        for (int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for (int i=nums.length-2; i>=0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for (int i=0; i<nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}  
 
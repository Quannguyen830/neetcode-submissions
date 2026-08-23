class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Here is my code for Products of Array Except Self. 
        // Pattern: First intention is using brute fore.
            // Haven't think of how to optimize it yet.
        // Data Structure: 
        // Core Challenge: How to know other numbers in
            // the array without using another nested loop

        int[] result = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            int product = 1;
            for (int j=0; j<nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }

            result[i] = product;
        }

        return result;
    }
}  
 
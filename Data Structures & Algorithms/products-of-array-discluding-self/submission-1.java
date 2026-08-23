class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Here is my code for Products of Array Except Self. 
        // Pattern: First intention is using brute fore.
            // Haven't think of how to optimize it yet.
        // Data Structure: 
        // Core Challenge: How to know other numbers in
            // the array without using another nested loop

        int product = 1;
        int numberOfZeroes = 0;

        for (int num: nums) {
            if (num == 0) {
                numberOfZeroes += 1;
            } else {
                product *= num;
            }
        }

        if (numberOfZeroes > 1) {
            return new int[nums.length];
        }

        int[] result = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (numberOfZeroes > 0) {
                result[i] = (nums[i] == 0) ? product : 0;
            } else {
                result[i] = product/nums[i];
            }
        }

        return result;
    }
}  
 
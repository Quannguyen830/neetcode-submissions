class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // int left = 0; right = numbers.length-1;
        // while (left < right) 
            // if (numbers[left] + numbers[right] == target) return;
            // if (<target) left++
            // if (>target) right--;
        // return int[0];

        int left = 0;
        int right = numbers.length-1;

        while (left < right) {
            int total = numbers[left] + numbers[right];

            if (total == target) {
                return new int[] {left+1, right+1};
            } else if (total < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0];
    }
}

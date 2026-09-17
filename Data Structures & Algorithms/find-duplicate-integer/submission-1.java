class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        int entrance = nums[0];
        while (true) {
            entrance = nums[entrance];
            slow = nums[slow];

            if (entrance == slow) {
                break;
            }
        }

        return entrance;
    }
}

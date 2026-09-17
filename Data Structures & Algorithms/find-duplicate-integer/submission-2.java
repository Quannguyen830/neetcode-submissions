class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        int entrance = 0;
        while (slow != entrance) {
            entrance = nums[entrance];
            slow = nums[slow];
        }

        return slow;
    }
}

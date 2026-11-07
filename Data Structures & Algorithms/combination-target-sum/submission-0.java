class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, int target, List<List<Integer>> result, List<Integer> current, int i) {
        if (quickSum(current) == target) {
            result.add(new ArrayList<>(current));
            return;
        } else if (quickSum(current) > target || i == nums.length) {
            return;
        }

        int num = nums[i];
        current.add(num);
        backtrack(nums, target, result, current, i);
        current.remove(Integer.valueOf(num));

        backtrack(nums, target, result, current, i+1);
    }

    private int quickSum(List<Integer> current) {
        int sum = 0;
        for (int num: current) sum += num;
        return sum;
    }
}

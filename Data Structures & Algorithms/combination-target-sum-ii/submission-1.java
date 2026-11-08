class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, new ArrayList<>(), 0, 0);
        return result;
    }

    private void backtrack(int[] nums, int target, List<List<Integer>> result, List<Integer> current, int i, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        } else if (sum > target || i == nums.length) {
            return;
        }

        int num = nums[i];
        current.add(num);
        backtrack(nums, target, result, current, i+1, sum+num);
        current.remove(current.size()-1);

        i += 1;
        while (i < nums.length && num == nums[i]) {
            i += 1;
        }
        backtrack(nums, target, result, current, i, sum);
    }
}

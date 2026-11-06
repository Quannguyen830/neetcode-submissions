class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, nums, result);
        return result;
    }

    private void backtrack(List<Integer> current, int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        int num = nums[i];
        current.add(num);

        i += 1;
        backtrack(current, i, nums, result);
        current.remove(Integer.valueOf(num));

        backtrack(current, i, nums, result);
    }
}

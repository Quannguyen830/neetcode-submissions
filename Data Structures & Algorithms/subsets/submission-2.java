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

        backtrack(current, i+1, nums, result);
        current.remove(current.size()-1);

        backtrack(current, i+1, nums, result);
    }
}

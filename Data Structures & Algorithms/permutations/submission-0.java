class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int index, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (used[i]) continue;

            current.add(num);
            used[i] = true;
            backtrack(nums, result, current, index+1, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}

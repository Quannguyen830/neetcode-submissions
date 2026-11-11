class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        int num = nums[i];

        current.add(num);
        backtrack(nums, result, current, i+1);
        current.remove(current.size()-1);
        
        i++;
        while (i < nums.length && num == nums[i]) {
            i++;
        }
        backtrack(nums, result, current, i);
    }
}

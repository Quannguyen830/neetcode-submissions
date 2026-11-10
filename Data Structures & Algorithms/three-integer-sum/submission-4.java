class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int l = i+1, r = nums.length-1;
            while (l < r) {
                int numL = nums[l], numR = nums[r];
                int total = numL + numR + nums[i];

                if (total > 0) {
                    r--;
                } else if (total < 0) {
                    l++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(numL);
                    list.add(numR);
                    list.add(nums[i]);

                    result.add(list);

                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }

                    while (l < r && nums[r] == nums[r+1]) {
                        r--;
                    }
                }
            }
        }

        return result;
    }
}

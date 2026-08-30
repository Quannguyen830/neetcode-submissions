class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort(nums)

        // for i:
        //     if nums[i] > 0 break
        //     if i>0 && nums[i] == nums[i-1] continue -> deduplicate i
        //     start, end
        //     while start < end
        //         if s+e+nums[i] < 0 s++
        //         else if > 0 e--
        //         else s+e+nums[i] == 0
        //             add to result
        //             s++, e--
        //             while (nums[s] == nums[s-1]) s++;
        //             while (nums[e] == nums[e+1]) e--;

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int numl = nums[l], numr = nums[r];
                int total = numl + numr + nums[i];

                if (total < 0)
                    l++;
                else if (total > 0)
                    r--;
                else {
                    result.add(Arrays.asList(numl, numr, nums[i]));

                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }

        return result;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort(nums)

        // for i:
        //     target = nums[i];
        //     start, end
        //     while start < end
        //         if s+e < target s++
        //         else e--
        //         else if s+e == target add to result

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) break;

            if (i>0 && nums[i] == nums[i-1]) continue;

            int start = i+1, end = nums.length-1;

            while (start < end) {
                int startNum = nums[start];
                int endNum = nums[end];
                int total = startNum + endNum + nums[i];

                if (total == 0) {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(
                        nums[i],
                        nums[start],
                        nums[end]
                    ));
                    result.add(triplet);
                    
                    start++;
                    end--;

                    while (start < end && nums[start] == nums[start-1]) start++;

                    while (start < end && nums[end] == nums[end+1]) end--;
                } else if (total < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return result;
    }
}

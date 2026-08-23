class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Here is my code for Two Sum. 
        // Pattern: Classic problem for HashMap. Because the problem lies on 
             // finding number. So the trick here is find the target that we
             // need to find by using the target value and each number.
             // So finding is the typical HashMap usage. Since they said that
             // there is only 1 valid solution, no need to store value. 
        // Data Structure: HashMap
        // Core Challenge: Know "One-Pass Hash Map" trick.

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}

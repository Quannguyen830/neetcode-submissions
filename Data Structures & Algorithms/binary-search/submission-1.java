class Solution {
    public int search(int[] nums, int target) {
        // int l, r, middle
        // while l<r:
        //     middle = (l+r)/2
        //     if nums[middle] < target r=middle
        //     else if nums[middle] > target l=middle
        //     else return middle

        // return -1;

        int l = 0, r = nums.length - 1, middle = 0;

        while (l <= r) {
            middle = l + (r-l) / 2;
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] > target)
                r = middle - 1;
            else
                l = middle + 1;
        }

        return -1;
    }
}

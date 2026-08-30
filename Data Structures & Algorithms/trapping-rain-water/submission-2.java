class Solution {
    public int trap(int[] height) {
        // maxl, maxr
        // l, r
        // result

        // while l < r
        //     if (maxl < maxr) l++, maxl = Math.max()
        //     else r--, maxr = Math.max();

        int l = 0, r = height.length-1;
        int maxl = height[l], maxr = height[r];
        int result = 0;

        while (l < r) {
            if (maxl < maxr) {
                if (maxl - height[l] > 0) result += maxl - height[l];
                l++;
                maxl = Math.max(maxl, height[l]);
            } else {
                if (maxr - height[r] > 0) result += maxr - height[r];
                r--;
                maxr = Math.max(maxr, height[r]);
            }
        }

        return result;
    }
}

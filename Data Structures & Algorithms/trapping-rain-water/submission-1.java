class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int l = 0, r = height.length - 1;
        int maxl = height[l], maxr = height[r];
        int result = 0;

        while (l <= r) {
            if (maxl < maxr) {
                if (maxl - height[l] > 0) result += maxl-height[l];
                maxl = Math.max(maxl, height[l]);
                l++;
            } else {
                if (maxr - height[r] > 0) result += maxr-height[r];
                maxr = Math.max(maxr, height[r]);
                r--;
            }
        }

        return result;
    }
}

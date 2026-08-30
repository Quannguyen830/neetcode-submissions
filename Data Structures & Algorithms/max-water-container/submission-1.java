class Solution {
    public int maxArea(int[] heights) {
        // s, e, max
        // while s < e
        //     max = Math.max(max, (e-s)*Math.min(heights[s], heights[e]))
        //     if heights[s] <= heights[e] s++
        //     else e--;

        int s=0, e=heights.length-1, max=0;

        while (s < e) {
            max = Math.max(max, (e-s) * Math.min(heights[s], heights[e]));

            if (heights[s] <= heights[e]) s++;
            else e--;
        }

        return max;
    }
}
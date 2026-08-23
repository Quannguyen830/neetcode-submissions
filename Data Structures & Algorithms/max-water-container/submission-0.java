class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;

        int left = 0;
        int right = heights.length-1;

        while (left < right) {
            boolean lor = (heights[left] >= heights[right]);
            int area = 0;

            if (lor) {
                area = heights[right] * (right-left);
                right--;
            } else {
                area = heights[left] * (right-left);
                left++;
            }

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
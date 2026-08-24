class Solution {
    public int maxProfit(int[] prices) {
        // left, right, max
        // while right != end
        //     if prices[left] > prices[right] left++, r = l
        //     else r++
        //     max = Math.max

        int left = 0, right = 1, max = 0;
        while (right < prices.length) {
            int l = prices[left];
            int r = prices[right];

            if (l > r) {
                left = right;
            } else {
                max = Math.max(r-l, max);
            }
            right++;
        }

        return max;
    }
}

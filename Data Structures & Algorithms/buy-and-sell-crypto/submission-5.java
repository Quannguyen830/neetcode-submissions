class Solution {
    public int maxProfit(int[] prices) {
        // left, right, max
        // while right != end
        //     if prices[left] > prices[right] left++, r = l
        //     else r++
        //     max = Math.max

        if (prices.length == 1) return 0;
        int l = 0, max = 0;

        for (int r=1; r<prices.length; r++) {
            if (prices[l] < prices[r]) {
                max = Math.max(prices[r] - prices[l], max);
            } else {
                l = r;
            }
        }

        return max;
    }
}

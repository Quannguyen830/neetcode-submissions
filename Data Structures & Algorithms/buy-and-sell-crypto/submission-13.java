class Solution {
    public int maxProfit(int[] prices) {
        // left, right, max
        // while right != end
        //     if prices[left] > prices[right] left++, r = l
        //     else r++
        //     max = Math.max

        if (prices.length == 1) return 0;
        int l = 0, r = 1, max = 0;
        while (r < prices.length) {
            if (prices[l] > prices[r]) {
                l = r;
            }

            max = Math.max(max, prices[r] - prices[l]);
            r++;
        }

        return max;
    }
}

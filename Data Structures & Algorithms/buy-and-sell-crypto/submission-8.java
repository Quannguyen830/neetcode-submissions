class Solution {
    public int maxProfit(int[] prices) {
        // left, right, max
        // while right != end
        //     if prices[left] > prices[right] left++, r = l
        //     else r++
        //     max = Math.max

        int l = 0, r = 0, max = 0;
        while (r != prices.length) {
            if (prices[l] > prices[r]) {
                l++;
                r = l;
            } else {
                r++;
            }

            max = Math.max(max, prices[r] - prices[l]);
        }

        return max;
    }
}

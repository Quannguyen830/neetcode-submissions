class Solution {
    public int maxProfit(int[] prices) {
        // left, right, max
        // while right != end
        //     if prices[left] > prices[right] left++, r = l
        //     else r++
        //     max = Math.max

        int left = 0, right = 0, max = 0;
        while (right <= prices.length-1) {
            int l = prices[left];
            int r = prices[right];

            if (l > r) {
                left = right;
                right++;
            } else {
                right++;
            }

            max = Math.max(r-l, max);
        }

        return max;
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;

        for (int pile: piles) {
            max = Math.max(max, pile);
        }

        while (min < max) {
            int mid = (min+max)/2;
            if (totalHours(piles, mid) < h) {
                max = mid;
            } else {
                min = mid+1;
            }
        }

        return max;
    }

    private int totalHours(int[] piles, int speed) {
        int result = 0;
        for (int pile: piles) {
            int hour = (int) Math.ceil((double) pile/speed);
            result += hour;
        }

        return result;
    }
}

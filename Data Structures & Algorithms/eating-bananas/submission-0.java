class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;

        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (totalHours(piles, mid) <= h) {
                max = mid;
            } else {
                min = mid+1;
            }
        }

        return min;
    }

    private static int totalHours(int[] piles, int speed) {
        int result = 0;
        for (int pile : piles) {
            result += (int) Math.ceil((double) pile / speed);
        }
        return result;
    }
}

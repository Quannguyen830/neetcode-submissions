class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lm = 0, rm = matrix.length - 1;
        int n = matrix[0].length - 1;
        int midm = 0;

        while (lm <= rm) {
            midm = lm + (rm - lm) / 2;
            if (target <= matrix[midm][n] && target >= matrix[midm][0]) {
                int ln = 0, rn = n;
                while (ln <= rn) {
                    int midn = ln + (rn - ln) / 2;
                    if (target < matrix[midm][midn])
                        rn = midn - 1;
                    else if (target > matrix[midm][midn])
                        ln = midn + 1;
                    else
                        return true;
                }
                return false;
            }
            else if (target > matrix[midm][n])
                lm = midm + 1;
            else {
                rm = midm - 1;
            }
        }

        return false;
    }
}

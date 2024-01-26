// Link: https://leetcode.com/problems/out-of-boundary-paths/
// Difficulty: Medium
// Time complexity: O(m*n*maxMove) where m and n are the lengths of the two strings
// Space complexity: O(m*n*maxMove) where m and n are the lengths of the two strings

class Solution {
    Integer[][][] memo; // memoization array
    int mod = 1_000_000_000 + 7;
    int rows, cols; // renaming m and n to rows and cols for better clarity

    public int findPaths(int rows, int cols, int maxMove, int startX, int startY) {
        memo = new Integer[rows][cols][maxMove + 1];
        this.rows = rows;
        this.cols = cols;
        return helper(maxMove, startX, startY);
    }

    int helper(int maxMove, int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return 1; // cell is out of bounds, count as one path
        }

        if (maxMove <= 0) {
            return 0; // no moves left
        }

        if (memo[x][y][maxMove] != null) {
            return memo[x][y][maxMove]; // return memoized result
        }

        int result = 0;
        result = (result + helper(maxMove - 1, x + 1, y)) % mod;
        result = (result + helper(maxMove - 1, x, y - 1)) % mod;
        result = (result + helper(maxMove - 1, x - 1, y)) % mod;
        result = (result + helper(maxMove - 1, x, y + 1)) % mod;

        memo[x][y][maxMove] = result; // store result in memo array
        return result;
    }
}

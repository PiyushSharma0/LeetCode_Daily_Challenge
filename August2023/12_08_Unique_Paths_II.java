// Link: https://leetcode.com/problems/unique-paths-ii/
// Difficulty: Medium
// Time complexity: O(m * n) since we need to fill in the DP array of size m * n.
// Space complexity: O(m * n) since we need to store the DP array of size m * n.

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // If the starting position or the ending position is an obstacle, there is no path.
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        
        // Create a DP array to store the number of unique paths to each cell.
        int[][] dp = new int[m][n];
        
        // Initialize the DP array for the first row and first column.
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 1) ? 0 : dp[0][j - 1];
        }
        
        // Fill in the DP array using bottom-up dynamic programming.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // If the cell is an obstacle, no paths can go through it.
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum of paths from above and left cells.
                }
            }
        }
        
        return dp[m - 1][n - 1]; // Return the total number of unique paths.
    }
}

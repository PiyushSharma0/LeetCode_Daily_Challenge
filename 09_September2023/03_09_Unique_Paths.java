// Link: https://leetcode.com/problems/unique-paths/
// Difficulty: Medium because of the DP
// Time complexity: O(m * n) where m is the number of rows and n is the number of columns
// Space complexity: O(m * n) where m is the number of rows and n is the number of columns

class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 2D array to store the number of unique paths for each cell
        int[][] dp = new int[m][n];
        
        // Initialize the top row and left column to 1 because there's only one way to reach any cell in those rows/columns
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill in the rest of the dp array using dynamic programming
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The number of unique paths to cell dp[i][j] is the sum of the paths from the cell above and the cell to the left
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        // The result is stored in the bottom-right cell of the dp array
        return dp[m - 1][n - 1];
    }
}

// Link: https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/
// Difficulty: Hard
// Time complexity: O(m * n) where m is the number of rows and n is the number of columns in the grid
// Space complexity: O(m * n) where m is the number of rows and n is the number of columns in the grid

import java.util.Arrays;

class Solution {
  public int countPaths(int[][] grid) {
    m = grid.length; // Number of rows in the grid
    n = grid[0].length; // Number of columns in the grid
    int ans = 0;
    // dp[i][j] := # of increasing paths starting from (i, j)
    dp = new int[m][n]; // Dynamic programming array to store computed results
    Arrays.stream(dp).forEach(A -> Arrays.fill(A, -1)); // Initialize dp array with -1

    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j) {
        ans += dfs(grid, i, j); // Count the number of increasing paths starting from (i, j)
        ans %= kMod; // Take modulo to avoid overflow
      }

    return ans;
  }

  private static final int kMod = 1_000_000_007; // Modulo value
  private final int[] dirs = {0, 1, 0, -1, 0}; // Directions: right, down, left, up
  private int m; // Number of rows in the grid
  private int n; // Number of columns in the grid
  private int[][] dp; // Dynamic programming array to store computed results

  private int dfs(int[][] grid, int i, int j) {
    if (dp[i][j] != -1)
      return dp[i][j]; // If the result for cell (i, j) is already computed, return it

    dp[i][j] = 1; // Current cell contributes 1 length

    for (int k = 0; k < 4; ++k) {
      final int x = i + dirs[k]; // New row index
      final int y = j + dirs[k + 1]; // New column index
      if (x < 0 || x == m || y < 0 || y == n)
        continue; // Skip if out of bounds
      if (grid[x][y] <= grid[i][j])
        continue; // Skip if the next cell is not strictly greater
      dp[i][j] += dfs(grid, x, y); // Compute the number of increasing paths recursively
      dp[i][j] %= kMod; // Take modulo to avoid overflow
    }

    return dp[i][j]; // Return the computed result for cell (i, j)
  }
}

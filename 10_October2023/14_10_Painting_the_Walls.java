// Link: https://leetcode.com/problems/painting-the-walls/description/
// Difficulty: Hard
// Time complexity: O(N^2)
// Space complexity: O(N^2)

class Solution {
  public int paintWalls(int[] cost, int[] time) {
    final int n = cost.length;
    dp = new int[n][n + 1]; // Initialize a 2D array for dynamic programming
    return paintWalls(cost, time, 0, time.length);
  }

  private static final int kMax = 500_000_000; // A constant representing a very large value
  private int[][] dp; // Memoization table for dynamic programming

  // Recursive function to calculate the minimum cost of painting walls
  private int paintWalls(int[] cost, int[] time, int i, int walls) {
    if (walls <= 0)
      return 0; // Base case: If no walls need to be painted, the cost is 0
    if (i == cost.length)
      return kMax; // Base case: If we've considered all walls and still need to paint more, return a large value

    if (dp[i][walls] > 0)
      return dp[i][walls]; // If we've already computed and cached this result, return it

    // Choose between picking the current wall or skipping it
    final int pick = cost[i] + paintWalls(cost, time, i + 1, walls - time[i] - 1); // Cost of picking the current wall
    final int skip = paintWalls(cost, time, i + 1, walls); // Cost of skipping the current wall

    // Store the minimum cost for the current state in the memoization table
    return dp[i][walls] = Math.min(pick, skip);
  }
}

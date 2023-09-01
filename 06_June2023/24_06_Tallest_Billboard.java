// Link: https://leetcode.com/problems/tallest-billboard/
// Difficulty: Hard
// Time Complexity: O(n * sum) where n is the number of rods and sum is the sum of all rod lengths
//  Space Complexity: O(n * sum) where n is the number of rods and sum is the sum of all rod lengths

import java.util.Arrays;

class Solution {
  public int tallestBillboard(int[] rods) {
    final int n = rods.length; // Number of rods
    final int sum = Arrays.stream(rods).sum(); // Sum of all rod lengths
    int[][] dp = new int[n + 1][sum + 1]; // 2D array to store the maximum possible height difference
    Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1)); // Initialize the dp array with -1
    dp[0][0] = 0; // Base case: No rods used, height difference is 0

    for (int i = 1; i <= n; ++i) { // Iterate through each rod
      final int h = rods[i - 1]; // Height of the current rod
      for (int j = 0; j <= sum - h; ++j) { // Iterate through possible height differences
        if (dp[i - 1][j] < 0)
          continue; // Skip if the height difference is not achievable

        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]); // Case 1: Do not use the current rod
        dp[i][j + h] = Math.max(dp[i][j + h], dp[i - 1][j]); // Case 2: Add the current rod to the taller side
        dp[i][Math.abs(j - h)] = Math.max(dp[i][Math.abs(j - h)], dp[i - 1][j] + Math.min(j, h));
        // Case 3: Add the current rod to the shorter side, adjusting the height difference

      }
    }

    return dp[n][0]; // Return the maximum possible height difference
  }
}

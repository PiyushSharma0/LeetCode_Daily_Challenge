// Link: https://leetcode.com/problems/min-cost-climbing-stairs/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n <= 1) {
            return 0; // No cost if there are 0 or 1 steps.
        }
        
        int[] dp = new int[n]; // Create an array to store the minimum cost to reach each step.
        
        // Initialize the first two steps' costs.
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        // Calculate the minimum cost for each subsequent step.
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        // The minimum cost to reach the top will be the minimum of the last two steps.
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}

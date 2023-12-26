// Link: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
// Difficulty: Medium
// Time complexity: O(n * k * target)
// Space complexity: O(n * target)

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][target + 1];
        
        // Initialize base case: when no dice are rolled and target is 0, there's one way (empty set).
        dp[0][0] = 1;

        // Dynamic programming to fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // Calculate the number of ways to reach the current target using i dice
                for (int face = 1; face <= k && face <= j; face++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - face]) % MOD;
                }
            }
        }

        return dp[n][target];
    }
}

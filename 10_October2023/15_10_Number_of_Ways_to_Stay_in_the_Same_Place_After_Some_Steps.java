// Link: https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
// Difficulty: Hard but not that hard
// Time complexity: O(steps * min(steps / 2, arrLen))
// Space complexity: O(steps * min(steps / 2, arrLen))

class Solution {
    public int numWays(int steps, int arrLen) {
        int MOD = 1000000007;
        int maxPosition = Math.min(steps / 2, arrLen - 1); // Maximum position the pointer can be at

        // Initialize a 2D array to store the number of ways to be at a position at a given step
        int[][] dp = new int[steps + 1][maxPosition + 1];
        dp[0][0] = 1; // Initial position is at index 0

        for (int step = 1; step <= steps; step++) {
            for (int position = 0; position <= maxPosition; position++) {
                dp[step][position] = dp[step][position] % MOD; // Prevent integer overflow

                // Stay in the same position
                dp[step][position] = (dp[step][position] + dp[step - 1][position]) % MOD;

                // Move one step to the left
                if (position > 0) {
                    dp[step][position] = (dp[step][position] + dp[step - 1][position - 1]) % MOD;
                }

                // Move one step to the right
                if (position < maxPosition) {
                    dp[step][position] = (dp[step][position] + dp[step - 1][position + 1]) % MOD;
                }
            }
        }

        return dp[steps][0];
    }
}

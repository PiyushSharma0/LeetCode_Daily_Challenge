// Link: https://leetcode.com/problems/k-inverse-pairs-array/
// Difficulty: Hard
// Time complexity: O(n*k^2)
// Space complexity: O(n*k)

class Solution {
    public int kInversePairs(int n, int k) {
        final int MOD = 1000000007;
        
        // dp[i][j] represents the number of arrays with length i and k inverse pairs
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int p = 0; p <= Math.min(j, i - 1); p++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % MOD;
                }
            }
        }
        
        return dp[n][k];
    }
}

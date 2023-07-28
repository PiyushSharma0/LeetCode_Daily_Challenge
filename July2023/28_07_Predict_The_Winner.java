// Link: https://leetcode.com/problems/predict-the-winner/
// Difficulty: Medium
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        
        // dp[i][j] will store the maximum score difference between player 1 and player 2 for the subarray nums[i..j]
        int[][] dp = new int[n][n];
        
        // Initialize dp[i][i] to be the value of nums[i]
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        
        // Fill the dp table for all possible subarrays of length 2 or more
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        
        // If the score difference for the entire array is greater than or equal to 0, then Player 1 can win
        return dp[0][n - 1] >= 0;
    }
}

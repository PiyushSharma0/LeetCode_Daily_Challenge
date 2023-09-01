// Link: https://leetcode.com/problems/longest-arithmetic-subsequence/
// Difficulty: Medium
// Time complexity: O(n^2)
// Space complexity: O(n^2)

class Solution {
  public int longestArithSeqLength(int[] nums) {
    final int n = nums.length;
    int ans = 0;
    // dp[i][k] := length of the longest arithmetic subsequence of nums
    // nums[0..i] with k = diff + 500
    int[][] dp = new int[n][1001];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < i; ++j) {
        final int k = nums[i] - nums[j] + 500;
        // Update dp[i][k] by taking the maximum of 2 and dp[j][k] + 1
        dp[i][k] = Math.max(2, dp[j][k] + 1);
        // Update the overall maximum length by comparing with ans
        ans = Math.max(ans, dp[i][k]);
      }
    }

    return ans; // Return the longest arithmetic subsequence length
  }
}
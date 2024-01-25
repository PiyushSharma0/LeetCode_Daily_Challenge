// Link: https://leetcode.com/problems/longest-common-subsequence/
// Difficulty: Medium
// Time complexity: O(m*n) where m and n are the lengths of the two strings
// Space complexity: O(m*n) where m and n are the lengths of the two strings

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Create a 2D array to store the length of LCS for subproblems
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array using bottom-up approach
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the LCS is stored in dp[m][n]
        return dp[m][n];
    }
}

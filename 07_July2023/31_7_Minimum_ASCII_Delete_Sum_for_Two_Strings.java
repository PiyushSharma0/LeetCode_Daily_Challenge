// Link: https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
// Difficulty: Medium
// Time complexity: O(m * n) where m is the length of s1 and n is the length of s2.
// Space complexity: O(m * n) where m is the length of s1 and n is the length of s2.

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        // dp[i][j] represents the minimum ASCII sum of deleted characters
        // to make s1.substring(0, i) and s2.substring(0, j) equal.
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the first row and first column.
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        
        // Fill the dp array.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1),
                                       dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        
        return dp[m][n];
    }
}

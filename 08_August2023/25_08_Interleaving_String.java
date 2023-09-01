// Link: https://leetcode.com/problems/interleaving-string/
// Difficulty: Hard because of the recurrence relation
// Time complexity: O(m * n) where m and n are the lengths of s1 and s2 respectively
// Space complexity: O(m * n) for the dp table

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        if (len1 + len2 != len3) {
            return false; // Length mismatch, s3 cannot be formed by interleaving s1 and s2
        }
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        
        // Base case: both strings are empty, so they can form an empty string
        dp[0][0] = true;
        
        // Fill the first row (s1 is empty)
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        
        // Fill the first column (s2 is empty)
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        
        // Fill the rest of the table using recurrence relation
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[len1][len2];
    }
}

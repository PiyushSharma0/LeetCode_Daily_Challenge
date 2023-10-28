// Link: https://leetcode.com/problems/count-vowels-permutation/
// Difficulty: Hard
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int countVowelPermutation(int n) {
        int MOD = 1000000007;
        
        // Create a 2D array dp, where dp[i][j] represents the count of strings of length i ending with vowel j.
        long[][] dp = new long[n + 1][5]; // 'a', 'e', 'i', 'o', 'u' => 0, 1, 2, 3, 4
        
        // Initialize base cases
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        
        // Fill the dp array using the rules
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % MOD; // 'a' can be followed by 'e', 'i', or 'u'
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD; // 'e' can be followed by 'a' or 'i'
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MOD; // 'i' can be followed by 'e' or 'o'
            dp[i][3] = dp[i - 1][2] % MOD; // 'o' can be followed by 'i'
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MOD; // 'u' can be followed by 'i' or 'o'
        }
        
        // Sum the counts of all vowels for strings of length n
        long count = 0;
        for (int i = 0; i < 5; i++) {
            count = (count + dp[n][i]) % MOD;
        }
        
        return (int) count;
    }
}

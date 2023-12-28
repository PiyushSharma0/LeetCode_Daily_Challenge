// Link: https://leetcode.com/problems/string-compression-ii/
// Difficulty: Hard
// Time complexity: O(n^2 * k)
// Space complexity: O(n * k)

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        // dp[i][k] := the length of the optimal compression of s[i..n) with at most k deletions
        dp = new int[s.length()][k + 1];
        Arrays.stream(dp).forEach(A -> Arrays.fill(A, kMax));
        return compression(s, 0, k);
    }

    // Constant representing a large value (initialized to a value greater than expected)
    private static final int kMax = 101;
    
    // Two-dimensional array for dynamic programming
    private int[][] dp;

    // Recursive function for compression
    private int compression(final String s, int i, int k) {
        // Base case: if k is negative, return a large value
        if (k < 0)
            return kMax;
        
        // Base case: if all characters are processed or remaining characters are less than or equal to k, return 0
        if (i == s.length() || s.length() - i <= k)
            return 0;

        // Memoization: if the result for the current state is already computed, return it
        if (dp[i][k] != kMax)
            return dp[i][k];

        int maxFreq = 0;
        int[] count = new int[128]; // Array to store character frequencies (assuming ASCII characters)

        // Make letters in s[i..j] be the same.
        // Keep the letter that has the maximum frequency in this range and remove
        // the other letters.
        for (int j = i; j < s.length(); ++j) {
            maxFreq = Math.max(maxFreq, ++count[s.charAt(j)]);
            
            // Recursive call to compute the optimal compression for the remaining substring
            dp[i][k] = Math.min(
                dp[i][k], // Update the dp table with the minimum length
                getLength(maxFreq) + compression(s, j + 1, k - (j - i + 1 - maxFreq))
            );
        }

        return dp[i][k];
    }

    // Returns the length to compress `maxFreq`.
    private int getLength(int maxFreq) {
        if (maxFreq == 1)
            return 1; // c
        if (maxFreq < 10)
            return 2; // [1-9]c
        if (maxFreq < 100)
            return 3; // [1-9][0-9]c
        return 4;   // [1-9][0-9][0-9]c
    }
}

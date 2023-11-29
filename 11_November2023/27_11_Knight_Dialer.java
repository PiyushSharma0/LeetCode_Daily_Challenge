// Link: https://leetcode.com/problems/knight-dialer/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int knightDialer(int n) {
        final int MOD = 1000000007;

        // Possible knight moves
        int[][] moves = {
            {4, 6}, {6, 8}, {7, 9}, {4, 8},
            {0, 3, 9}, {}, {0, 1, 7}, {2, 6},
            {1, 3}, {2, 4}
        };

        // Initialize the dp array to store the number of ways to reach each digit at each step
        int[][] dp = new int[n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1; // There is 1 way to dial a number of length 1 starting from any digit
        }

        // Calculate the number of ways for each step
        for (int step = 1; step < n; step++) {
            for (int digit = 0; digit < 10; digit++) {
                for (int move : moves[digit]) {
                    dp[step][digit] = (dp[step][digit] + dp[step - 1][move]) % MOD;
                }
            }
        }

        // Sum up the number of ways for each digit at the last step
        int result = 0;
        for (int digit = 0; digit < 10; digit++) {
            result = (result + dp[n - 1][digit]) % MOD;
        }

        return result;
    }
}

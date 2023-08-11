// Link: https://leetcode.com/problems/coin-change-2/
// Difficulty: Medium
// Time complexity: O(n * amount) - Nested for loops
// Space complexity: O(amount) - Dynamic programming array

class Solution {
    public int change(int amount, int[] coins) {
        // Create a dynamic programming array to store the number of combinations for each amount
        int[] dp = new int[amount + 1];
        
        // Base case: There's one way to make amount 0, which is by not selecting any coins
        dp[0] = 1;
        
        // Loop through each coin denomination
        for (int coin : coins) {
            // For each coin, update dp[i] for all values of i that can be made using this coin
            // We start from coin value because any amount less than the coin value cannot be made
            for (int i = coin; i <= amount; i++) {
                // Accumulate the number of combinations for the current amount (i)
                // by adding the number of combinations for the amount (i - coin)
                dp[i] += dp[i - coin];
            }
        }
        
        // The final result is stored in dp[amount], which represents the number of combinations
        // to make up the given amount using the provided coin denominations
        return dp[amount];
    }
}

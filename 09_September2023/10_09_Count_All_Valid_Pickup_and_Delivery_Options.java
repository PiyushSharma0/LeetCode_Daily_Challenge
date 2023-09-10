// Link: https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
// Difficulty: Hard but easy to understand
// Time complexity: O(n) where n is the number of orders
// Space complexity: O(n)

class Solution {
    public int countOrders(int n) {
        long MOD = 1000000007;
        
        // Initialize dp array with size n+1
        long[] dp = new long[n + 1];
        dp[0] = 1;  // There is only one way to arrange 0 orders, which is an empty sequence.

        // Calculate the number of valid sequences for each n from 1 to n.
        for (int i = 1; i <= n; i++) {
            // Calculate the number of ways to arrange the current order (pickup and delivery) within
            // the existing sequence of (i-1) orders. There are i * 2 positions to insert the
            // new order (pickup and delivery).
            dp[i] = dp[i - 1] * (2 * i - 1) % MOD;
            
            // Multiply by i to account for the different orderings of the new order.
            dp[i] = (dp[i] * i) % MOD;
        }
        
        return (int) dp[n];
    }
}

// Link: https://leetcode.com/problems/minimum-penalty-for-a-shop/
// Difficulty: Medium because of the greedy approach
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int bestClosingTime(String customers) {
        int ans = 0;           // Variable to store the best closing hour
        int profit = 0;        // Current profit
        int maxProfit = 0;     // Maximum profit achieved

        for (int i = 0; i < customers.length(); ++i) {
            // Increase the profit if customers come, decrease if no customers
            profit += customers.charAt(i) == 'Y' ? 1 : -1;
            
            // Update the maximum profit and best closing hour
            if (profit > maxProfit) {
                maxProfit = profit;
                ans = i + 1;  // i + 1 because hours are 0-indexed but answers are 1-indexed
            }
        }

        return ans;
    }
}

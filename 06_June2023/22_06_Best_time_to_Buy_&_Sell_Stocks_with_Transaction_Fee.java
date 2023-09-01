// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public int maxProfit(int[] prices, int fee) {
    int sell = 0; // Variable to store the maximum profit when not holding any stock
    int hold = Integer.MIN_VALUE; // Variable to store the maximum profit when holding a stock

    for (final int price : prices) { // Iterate through each price in the prices array
      int prevHold = hold; // Store the previous value of hold before updating it
      sell = Math.max(sell, prevHold + price); // Update the sell variable by comparing the current sell value with the profit obtained by selling at the current price
      hold = Math.max(hold, sell - price - fee); // Update the hold variable by comparing the current hold value with the profit obtained by buying at the current price minus the fee
    }

    return sell; // Return the maximum profit obtained by selling the stock
  }
}

// Link: https://leetcode.com/problems/buy-two-chocolates/description/
// Difficulty: Easy
// Time Complexity: O(n) where n is the number of elements in the prices array
// Space Complexity: O(1)

class Solution {
  public int buyChoco(int[] prices, int money) {
    // Initialize two variables to store the minimum and second minimum prices
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;

    // Iterate through the prices array
    for (final int price : prices) {
      // Update min1 and min2 based on the current price
      if (price <= min1) {
        min2 = min1;    // Move the current min1 to min2
        min1 = price;   // Update min1 with the current price
      } else if (price < min2) {
        min2 = price;   // Update min2 with the current price
      }
    }

    // Calculate the minimum cost by adding min1 and min2
    final int minCost = min1 + min2;

    // Return the leftover money after buying two chocolates
    return minCost > money ? money : money - minCost;
  }
}

// Link: https://leetcode.com/problems/minimum-cost-to-make-array-equal/
// Difficulty: Hard
// Time complexity: O(nlog(max(nums)−min(nums))) where 'n' is the length of the 'nums' array
// Space complexity: O(1)

import java.util.Arrays;

class Solution {
  public long minCost(int[] nums, int[] cost) {
    long ans = 0; // Variable to store the minimum cost
    int l = Arrays.stream(nums).min().getAsInt(); // Get the minimum value from the 'nums' array
    int r = Arrays.stream(nums).max().getAsInt(); // Get the maximum value from the 'nums' array

    // Perform binary search to find the minimum cost
    while (l < r) {
      final int m = (l + r) / 2; // Calculate the middle value
      final long cost1 = getCost(nums, cost, m); // Get the cost using 'm' as the target value
      final long cost2 = getCost(nums, cost, m + 1); // Get the cost using 'm+1' as the target value
      ans = Math.min(cost1, cost2); // Update the minimum cost
      if (cost1 < cost2)
        r = m; // Update the right pointer if cost1 is less than cost2
      else
        l = m + 1; // Update the left pointer if cost1 is greater than or equal to cost2
    }

    return ans; // Return the minimum cost
  }

  // Helper function to calculate the cost for a given target value
  private long getCost(int[] nums, int[] cost, int target) {
    long res = 0; // Variable to store the cost
    for (int i = 0; i < nums.length; ++i)
      res += Math.abs(nums[i] - target) * (long) cost[i]; // Calculate the cost by taking the absolute difference between the number and the target, and multiplying it by the corresponding cost
    return res; // Return the cost
  }
}

// Link: https://leetcode.com/problems/minimum-replacements-to-sort-array/
// Difficulty: Hard but I think it's Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public long minimumReplacement(int[] nums) {
    long ans = 0;

    // Initialize the maximum value as the last element of the array
    int max = nums[nums.length - 1];

    // Iterate through the array in reverse order
    for (int i = nums.length - 2; i >= 0; --i) {
      // Calculate the number of operations needed to split the current element
      final int ops = (nums[i] - 1) / max;
      
      // Add the number of operations to the total operations count
      ans += ops;
      
      // Update the maximum value considering the number of operations
      max = nums[i] / (ops + 1);
    }

    return ans;
  }
}

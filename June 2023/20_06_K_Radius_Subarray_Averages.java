// Link: https://leetcode.com/problems/k-radius-subarray-averages/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

import java.util.Arrays;

class Solution {
  public int[] getAverages(int[] nums, int k) {
    final int n = nums.length;
    final int size = 2 * k + 1;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    
    // If the window size is greater than the number of elements in the array, return the filled array
    if (size > n)
      return ans;

    long sum = 0;

    // Calculate the initial sum of the first window of size 'size'
    for (int i = 0; i < size; ++i)
      sum += nums[i];

    // Iterate through the array starting from index 'k' until index 'n-k-1'
    for (int i = k; i + k < n; ++i) {
      // Calculate the average and store it in the 'ans' array
      ans[i] = (int) (sum / size);
      
      // Update the sum for the next window by subtracting the element at index 'i-k' and adding the element at index 'i+k+1'
      if (i + k + 1 < n)
        sum += nums[i + k + 1] - nums[i - k];
    }

    return ans;
  }
}

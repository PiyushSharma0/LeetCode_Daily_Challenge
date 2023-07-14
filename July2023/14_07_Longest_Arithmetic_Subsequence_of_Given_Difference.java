// Link: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int longestSubsequence(int[] arr, int difference) {
    int ans = 0; // Variable to store the maximum length of the subsequence
    Map<Integer, Integer> lengthAt = new HashMap<>(); // Map to store the length of subsequence ending at each element

    // Iterate through the array
    for (final int a : arr) {
      // Calculate the length of the subsequence ending at the current element
      // by adding 1 to the length of the subsequence ending at (current element - difference)
      int length = lengthAt.getOrDefault(a - difference, 0) + 1;

      // Update the length of the subsequence ending at the current element
      lengthAt.put(a, length);

      // Update the maximum length if the current length is greater
      ans = Math.max(ans, length);
    }

    return ans; // Return the maximum length of the subsequence
  }
}

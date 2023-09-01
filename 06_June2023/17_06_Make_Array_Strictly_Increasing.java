// Link: https://leetcode.com/problems/make-array-strictly-increasing/
// Difficulty: Hard
// Time complexity: O(N^2)
// Space complexity: O(N)

import java.util.*;

class Solution {
  public int makeArrayIncreasing(int[] arr1, int[] arr2) {
    // dp[i] := min steps to reach i at previous round
    Map<Integer, Integer> dp = new HashMap<>();
    dp.put(-1, 0); // Initialize with 0 steps to reach -1 (dummy value)

    Arrays.sort(arr2); // Sort arr2 in ascending order

    for (final int a : arr1) {
      Map<Integer, Integer> nextDp = new HashMap<>();
      for (final int val : dp.keySet()) {
        final int steps = dp.get(val);
        // It's possible to use the value in arr1
        if (a > val)
          nextDp.put(a, Math.min(nextDp.getOrDefault(a, Integer.MAX_VALUE), steps));
        // Also try the value in arr2
        final int i = firstGreater(arr2, val); // Find the first value in arr2 greater than val
        if (i < arr2.length)
          nextDp.put(arr2[i], Math.min(nextDp.getOrDefault(arr2[i], Integer.MAX_VALUE), steps + 1));
      }
      if (nextDp.isEmpty())
        return -1; // It's not possible to make arr1 strictly increasing
      dp = nextDp;
    }

    return Collections.min(dp.values()); // Return the minimum steps from all possible values in dp
  }

  private int firstGreater(int[] A, int val) {
    final int i = Arrays.binarySearch(A, val + 1);
    return i < 0 ? -(i + 1) : i; // Return the index of the first value greater than val in A
  }
}

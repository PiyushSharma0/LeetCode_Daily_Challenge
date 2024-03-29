// Link: https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
// Difficulty: Medium
// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
  public boolean validPartition(int[] nums) {
    final int n = nums.length;
    // dp[i] := true if there's a valid partition for first i elements
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    dp[2] = nums[0] == nums[1];

    for (int i = 3; i <= n; ++i)
      dp[i] = (dp[i - 2] && nums[i - 2] == nums[i - 1]) ||
              (dp[i - 3] && ((nums[i - 3] == nums[i - 2] && nums[i - 2] == nums[i - 1]) ||
                             (nums[i - 3] + 1 == nums[i - 2] && nums[i - 2] + 1 == nums[i - 1])));

    return dp[n];
  }
}

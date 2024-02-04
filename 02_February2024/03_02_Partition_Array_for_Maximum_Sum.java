// Link: https://leetcode.com/problems/partition-array-for-maximum-sum/
// Difficulty: Medium
// Time Complexity: O(n * k)
// Space Complexity: O(n)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                max = Math.max(max, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + max * j);
            }
        }

        return dp[n];
    }
}

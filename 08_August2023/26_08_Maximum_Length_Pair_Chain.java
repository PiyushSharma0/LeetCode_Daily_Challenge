// Link: https://leetcode.com/problems/maximum-length-of-pair-chain/
// Difficulty: Medium
// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        // Sort the pairs based on the second element (righti)
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        int n = pairs.length;
        int[] dp = new int[n]; // To store the maximum chain length up to each pair

        // Initialize the dp array with 1 as the minimum chain length for each pair is 1
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxChainLength = 0;
        for (int length : dp) {
            maxChainLength = Math.max(maxChainLength, length);
        }

        return maxChainLength;
    }
}
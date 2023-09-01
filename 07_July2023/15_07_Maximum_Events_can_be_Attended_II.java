// Link: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/
// Difficulty: Hard
// Time complexity: O(n^2)
// Space complexity: O(n^2)

import java.util.Arrays;

class Solution {
    public int maxValue(int[][] events, int k) {
        dp = new Integer[events.length][k + 1];
        // Sort the events array based on their start time in ascending order
        // If the start times are equal, sort based on the end time in ascending order
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return maxValue(events, 0, k);
    }

    private Integer[][] dp; // 2D array to store calculated maximum values

    private int maxValue(int[][] events, int i, int k) {
        if (k == 0 || i == events.length)
            return 0;
        if (dp[i][k] != null)
            return dp[i][k];

        final int j = binarySearch(events, i + 1, events[i][1] + 1);
        // Choose the current event and recursively find the maximum value
        // by either including or excluding the next event
        return dp[i][k] = Math.max(events[i][2] + maxValue(events, j, k - 1), maxValue(events, i + 1, k));
    }

    // Binary search to find the index of the next event whose start time is greater than or equal to the target
    private int binarySearch(int[][] events, int left, int target) {
        int right = events.length;

        while (left < right) {
            final int mid = (left + right) / 2;
            if (events[mid][0] >= target)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}

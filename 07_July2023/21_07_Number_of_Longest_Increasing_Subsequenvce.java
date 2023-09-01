// Link: https://leetcode.com/problems/number-of-longest-increasing-subsequence/
// Difficulty: Medium
// Time complexity: O(n^2)
// Space complexity: O(n)

import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] lengths = new int[n]; // lengths[i] stores the length of the longest increasing subsequence ending at index i
        int[] counts = new int[n]; // counts[i] stores the count of longest increasing subsequences ending at index i

        // Initialize lengths and counts arrays with default values
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);

        int maxLength = 1;

        // Calculate lengths and counts for each index
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, lengths[i]);
        }

        int result = 0;

        // Count the number of longest increasing subsequences
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLength) {
                result += counts[i];
            }
        }

        return result;
    }
}

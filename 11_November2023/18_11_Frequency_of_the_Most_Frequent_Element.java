// Link: https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Difficulty: Medium
// Time complexity: O(nlogn)
// Space complexity: O(n)

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        // Sort the array to efficiently find the maximum frequency
        Arrays.sort(nums);

        int maxFreq = 0;
        int left = 0;
        long sum = 0;

        // Iterate through the array with a sliding window
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // Ensure the window size is valid (within k operations)
            while ((long) nums[right] * (right - left + 1) > sum + k) {
                sum -= nums[left];
                left++;
            }

            // Update the maximum frequency
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}
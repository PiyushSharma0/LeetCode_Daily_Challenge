// Link: https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
// Difficulty: Hard because of the greedy approach
// Time complexity: O(n) where n is the length of the input array
// Space complexity: O(n) where n is the length of the input array

class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] nums = new int[n + 1]; // Store the maximum coverage of each tap
        
        // Calculate the maximum coverage for each tap and store in nums array
        for (int i = 0; i <= n; ++i) {
            int l = Math.max(0, i - ranges[i]);
            int r = Math.min(n, i + ranges[i]);
            nums[l] = Math.max(nums[l], r - l); // Store the maximum coverage at the left position
        }

        int ans = 0; // Count of taps used
        int end = 0; // Represents the rightmost point covered by the current set of taps
        int farthest = 0; // Represents the farthest point that can be reached with the current set of taps

        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, i + nums[i]); // Update the farthest point reachable by the current set of taps
            
            if (i == end) { // If the current index reaches the end of the current set of taps
                ++ans; // Increment the taps count
                end = farthest; // Update the end to the farthest reachable point
            }
        }

        return end == n ? ans : -1; // Return ans if the entire garden is covered, otherwise return -1
    }
}

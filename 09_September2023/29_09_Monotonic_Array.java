// Link: https://leetcode.com/problems/monotonic-array/
// Difficulty: Easy
// Time complexity: O(n) where n is the length of the array
// Space complexity: O(1)

class Solution {
    public boolean isMonotonic(int[] nums) {
        // Initialize two boolean variables to track increasing and decreasing conditions
        boolean increasing = true; // Assume it's increasing initially
        boolean decreasing = true; // Assume it's decreasing initially

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Check if the current element is greater than the next element
            if (nums[i - 1] > nums[i]) {
                increasing = false; // It's not increasing
            }
            // Check if the current element is less than the next element
            if (nums[i - 1] < nums[i]) {
                decreasing = false; // It's not decreasing
            }
        }

        // If both increasing and decreasing are still true, it's either increasing or decreasing
        return increasing || decreasing;
    }
}

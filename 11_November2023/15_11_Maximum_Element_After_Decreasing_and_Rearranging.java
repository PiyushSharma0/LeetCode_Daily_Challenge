// Link: https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
// Difficulty: Medium
// Time Complexity: O(n log n)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr); // Step 1

        int n = arr.length;
        arr[0] = 1; // Ensure the first element is 1

        // Iterate through the array to satisfy the second condition
        for (int i = 1; i < n; i++) {
            // Update the element to ensure abs(arr[i] - arr[i - 1]) <= 1
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        return arr[n - 1]; // Return the maximum value after operations
    }
}

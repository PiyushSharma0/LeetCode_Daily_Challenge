// Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
// Difficulty: Hard
// Time complexity: O(nlogn)
// Space complexity: O(1)

import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        // If the array has 0 or 1 element, no operations are needed.
        if (n <= 1) {
            return 0;
        }

        // Step 1: Sort the array in ascending order.
        Arrays.sort(nums);

        int left = 0; // Initialize the left pointer.
        int minOperations = n; // Initialize the minimum operations to a maximum value initially.

        for (int right = 0; right < n; right++) {
            // Step 4: Iterate through the array using the right pointer.
            
            // Step 5: While the difference between the maximum and minimum elements
            // in the current window is greater than or equal to n - 1, move the left pointer.
            while (nums[right] - nums[left] > n - 1) {
                left++;
            }

            // Step 6: Update minOperations with the minimum of its current value
            // and the difference between the array length and the size of the current window.
            minOperations = Math.min(minOperations, n - (right - left + 1));
        }

        // Step 7: Return the minimum operations required.
        return minOperations;
    }
}
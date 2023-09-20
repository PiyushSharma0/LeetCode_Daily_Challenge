// Link: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0; // Total sum of all elements in the array
        int currentSum = 0; // Current sum of elements in the sliding window
        int minLength = 0; // Minimum length of subarray to remove
        
        // Calculate the total sum of all elements in the array
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
                
        // If the total sum is less than the target sum, it's impossible to achieve x
        if (totalSum < x) {
            return -1;
        }
        
        // If the total sum is equal to the target sum, we can remove the entire array
        if (totalSum == x) {
            return n;
        }
        
        // Calculate the target sum we want to achieve
        totalSum = totalSum - x;

        // Initialize two pointers for the sliding window
        int start = 0; // Start of the window
        int end = 0;   // End of the window

        
        while (end < n) {
            currentSum += nums[end]; // Expand the window by adding elements
            
            // Shrink the window from the left until the sum is less than or equal to the target
            while (currentSum > totalSum) {
                currentSum -= nums[start];
                start++;
            }
            
            // If the current sum equals the target sum, update the minimum length
            if (currentSum == totalSum) {
                int currentLength = end - start + 1;
                minLength = Math.max(minLength, currentLength);
            }
            
            end++; // Expand the window to the right
        }
        
        // If minLength remains Integer.MAX_VALUE, no subarray was found
        if (minLength == 0) {
            return -1;
        }
        
        // Return the minimum number of operations to reduce x to exactly 0
        return n - minLength;
    }
}
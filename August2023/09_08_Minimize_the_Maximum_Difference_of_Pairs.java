// Link: https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/   
// Difficulty: Medium
// Time complexity: O(n log n) - Binary search + sorting
// Space complexity: O(1)

import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        // Sort the array in ascending order
        Arrays.sort(nums);
        
        // Initialize search space
        int left = 0; // Minimum possible maximum difference
        int right = nums[nums.length - 1] - nums[0]; // Maximum possible maximum difference
        
        // Binary search to find the optimal maximum difference
        while (left < right) {
            int mid = (left + right) / 2; // Midpoint of search space
            
            // Check if it's possible to create p pairs with max difference <= mid
            if (valid(nums, mid, p)) {
                right = mid; // Narrow the search space to the left
            } else {
                left = mid + 1; // Narrow the search space to the right
            }
        }
        
        return left; // The minimum maximum difference
    }
    
    // Helper function to check if it's possible to create p pairs with max difference <= mid
    private boolean valid(int[] nums, int mid, int p) {
        int count = 0; // Number of pairs formed
        int i = 0; // Index pointer
        
        // Iterate through the array to form pairs
        while (i < nums.length - 1 && count < p) {
            // If the difference between current and next element is <= mid, form a pair
            if (nums[i + 1] - nums[i] <= mid) {
                count++; // Increment pair count
                i += 2; // Move to the next possible pair
            } else {
                i++; // Move to the next element
            }
        }
        
        return count >= p; // Return true if p pairs were formed with max difference <= mid
    }
}

// Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Difficulty: Medium
// Time complexity: O(logn)
// Space complexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Search for the leftmost occurrence of the target.
        result[0] = findLeftMost(nums, target);
        
        // Search for the rightmost occurrence of the target.
        result[1] = findRightMost(nums, target);
        
        return result;
    }
    
    // Helper function to find the leftmost occurrence of the target.
    private int findLeftMost(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftMost = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                leftMost = mid;
                right = mid - 1; // Continue searching on the left side.
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return leftMost;
    }
    
    // Helper function to find the rightmost occurrence of the target.
    private int findRightMost(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightMost = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                rightMost = mid;
                left = mid + 1; // Continue searching on the right side.
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return rightMost;
    }
}

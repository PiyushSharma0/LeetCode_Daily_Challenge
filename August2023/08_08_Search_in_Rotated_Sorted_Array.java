// Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
// Difficulty: Medium
// Time complexity: O(log n) - Binary search
// Space complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        // Find the pivot index
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        int pivot = left;
        left = 0;
        right = n - 1;
        
        // Perform binary search based on the pivot index
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = nums[(mid + pivot) % n];
            
            if (midValue == target) {
                return (mid + pivot) % n; // Adjust index to account for rotation
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Target not found
    }
}

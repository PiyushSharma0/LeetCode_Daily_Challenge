// Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// Difficulty: Medium
// Time complexity: O(log n) - Binary search
// Space complexity: O(1)

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // If the mid element is the target, return true
            if (nums[mid] == target) {
                return true;
            }
            
            // Check if the left half is sorted
            if (nums[left] < nums[mid]) {
                // If target is in the left half and within the sorted range, narrow the search to the left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Check if the right half is sorted
            else if (nums[left] > nums[mid]) {
                // If target is in the right half and within the sorted range, narrow the search to the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // If there's a possibility of duplicates
            else {
                left++; // Move left pointer towards the right
            }
        }
        
        return false; // Target element not found
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums = {4, 5, 6, 6, 7, 0, 1, 2, 4, 4};
        int target = 5;
        
        boolean result = solution.search(nums, target);
        
        System.out.println("Is target present in the array? " + result);
    }
}

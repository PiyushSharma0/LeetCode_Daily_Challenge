// Link: https://leetcode.com/problems/search-a-2d-matrix/
// Difficulty: Medium but can be solved in O(log(m * n)) time
// Time Complexity: O(log(m * n)) where m is the number of rows and n is the number of columns
// Space Complexity: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0;                 // Initialize left pointer
        int right = rows * cols - 1;  // Initialize right pointer
        
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Calculate middle index
            int midValue = matrix[mid / cols][mid % cols];  // Convert mid index to row and column
            
            if (midValue == target) {
                return true;  // Target found, return true
            } else if (midValue < target) {
                left = mid + 1;  // Adjust left pointer to search right half
            } else {
                right = mid - 1;  // Adjust right pointer to search left half
            }
        }
        
        return false;  // Target not found, return false
    }
}

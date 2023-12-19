// Link: https://leetcode.com/problems/image-smoother/
// Difficulty: Easy
// Time Complexity: O(m * n) where m and n are the number of rows and columns in the matrix respectively
// Space Complexity: O(m * n) where m and n are the number of rows and columns in the matrix respectively

class Solution {
    // Function to apply the image smoother to the given matrix.
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;  // Number of rows in the matrix
        int n = img[0].length;  // Number of columns in the matrix
        int[][] result = new int[m][n];  // Result matrix to store smoothed values
        
        // Iterate through each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Get the smoothed value for the current cell and update the result matrix
                result[i][j] = getSmoothedValue(img, i, j, m, n);
            }
        }
        
        // Return the final smoothed image
        return result;
    }
    
    // Function to calculate the smoothed value for a given cell and its surrounding cells
    private int getSmoothedValue(int[][] img, int row, int col, int m, int n) {
        int sum = 0;  // Variable to store the sum of pixel values
        int count = 0;  // Variable to store the count of pixels
        
        // Iterate through the surrounding cells of the current cell
        for (int i = Math.max(0, row - 1); i <= Math.min(m - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(n - 1, col + 1); j++) {
                sum += img[i][j];  // Add the pixel value to the sum
                count++;  // Increment the count
            }
        }
        
        // Calculate and return the average value (rounded down)
        return sum / count;
    }
}

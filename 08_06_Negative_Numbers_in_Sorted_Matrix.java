// Link: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
// Difficulty: Easy
// Time Complexity: O(m + n) where m is the number of rows and n is the number of columns in the grid
// Space Complexity: O(1)

public int countNegatives(int[][] grid) {
    // Get the number of rows and columns in the grid
    int rows = grid.length;
    int cols = grid[0].length;

    // Start from the bottom-left corner
    int row = rows - 1;
    int col = 0;

    // Initialize count to keep track of the number of negative numbers
    int count = 0;

    // Traverse the grid from bottom-left to top-right
    while (row >= 0 && col < cols) {
        // If the current element is negative, increment count by the number of remaining elements in the row
        if (grid[row][col] < 0) {
            count += cols - col;
            // Move up to the next row
            row--;
        } else {
            // Move to the next column
            col++;
        }
    }

    // Return the count of negative numbers in the grid
    return count;
}
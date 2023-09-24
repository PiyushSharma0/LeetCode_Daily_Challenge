// Link: https://leetcode.com/problems/champagne-tower/
// Difficulty: Medium
// Time complexity: O(R^2), where R is the number of rows.
// Space complexity: O(R^2), where R is the number of rows.

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // Create a 2D array to represent the glasses and their fill levels.
        double[][] glasses = new double[query_row + 1][query_row + 1];
        
        // Initialize the top glass with the poured champagne.
        glasses[0][0] = (double) poured;

        // Iterate through each row up to the desired row.
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                // Calculate the overflow of champagne in the current glass.
                double overflow = (glasses[i][j] - 1.0) / 2.0;
                
                // If there is overflow, distribute it equally to the glasses in the next row.
                if (overflow > 0) {
                    glasses[i + 1][j] += overflow;     // Left glass in the next row
                    glasses[i + 1][j + 1] += overflow; // Right glass in the next row
                }
            }
        }

        // Return the content of the requested glass, ensuring it doesn't exceed 1.0.
        return Math.min(1.0, glasses[query_row][query_glass]);
    }
}

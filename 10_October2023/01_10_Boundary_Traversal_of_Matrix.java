// Link: https://practice.geeksforgeeks.org/problems/boundary-traversal-of-matrix-1587115620/1
// Time complexity: O(n * m)
// Space complexity: O(n * m)

import java.util.ArrayList;

class Solution {
    // Function to return list of integers that form the boundary
    // traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m) {
        ArrayList<Integer> result = new ArrayList<>();

        if (n == 1) {
            // If there's only one row, traverse it from left to right.
            for (int j = 0; j < m; j++) {
                result.add(matrix[0][j]);
            }
        } else if (m == 1) {
            // If there's only one column, traverse it from top to bottom.
            for (int i = 0; i < n; i++) {
                result.add(matrix[i][0]);
            }
        } else {
            // Traverse the first row from left to right.
            for (int j = 0; j < m; j++) {
                result.add(matrix[0][j]);
            }

            // Traverse the last column from top to bottom.
            for (int i = 1; i < n; i++) {
                result.add(matrix[i][m - 1]);
            }

            // Traverse the last row from right to left.
            for (int j = m - 2; j >= 0; j--) {
                result.add(matrix[n - 1][j]);
            }

            // Traverse the first column from bottom to top.
            for (int i = n - 2; i > 0; i--) {
                result.add(matrix[i][0]);
            }
        }

        return result;
    }
}
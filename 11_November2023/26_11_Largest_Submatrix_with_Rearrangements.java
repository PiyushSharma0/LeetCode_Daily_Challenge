// Link: https://leetcode.com/problems/largest-submatrix-with-rearrangements/
// Difficulty: Medium
// Time complexity: O(m * n * log(n))
// Space complexity: O(1)

import java.util.Arrays;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Calculate the height of consecutive ones ending at each column
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        
        // Sort each row in non-increasing order based on the height
        for (int i = 0; i < m; i++) {
            Arrays.sort(matrix[i]);
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
        
        // Calculate the maximum area for each row
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int height = matrix[i][j];
                int width = j + 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }
        
        return maxArea;
    }
}

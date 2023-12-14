// Link: https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
// Difficulty: Medium
// Time complexity: O(m*n)
// Space complexity: O(m+n)

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] diff = new int[m][n];

        // Calculate the number of ones in each row and column
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                onesRow[i] += grid[i][j];
                onesCol[j] += grid[i][j];
            }
        }

        // Calculate the number of zeros in each row and column
        int[] zerosRow = new int[m];
        int[] zerosCol = new int[n];
        for (int i = 0; i < m; i++) {
            zerosRow[i] = n - onesRow[i];
        }
        for (int j = 0; j < n; j++) {
            zerosCol[j] = m - onesCol[j];
        }

        // Calculate the difference matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }

        return diff;
    }
}

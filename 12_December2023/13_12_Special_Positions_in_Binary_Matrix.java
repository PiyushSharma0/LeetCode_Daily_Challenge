// Link: https://leetcode.com/problems/special-positions-in-a-binary-matrix/
// Difficulty: Easy
// Time complexity: O(m*n)
// Space complexity: O(m+n)

class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCount = new int[m];  // Array to store the count of ones in each row
        int[] colCount = new int[n];  // Array to store the count of ones in each column
        int count = 0;  // Variable to store the count of special positions

        // Count ones in each row and each column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowCount[i] += mat[i][j];
                colCount[j] += mat[i][j];
            }
        }

        // Check for special positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    // If the element is 1 and it is the only one in its row and column
                    count++;
                }
            }
        }

        return count;
    }
}

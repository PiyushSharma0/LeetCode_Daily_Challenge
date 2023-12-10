// Link: https://leetcode.com/problems/transpose-matrix/
// Difficulty: Easy
// Time complexity: O(n * m) where n is the number of rows and m is the number of columns
// Space complexity: O(n * m) where n is the number of rows and m is the number of columns

class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            
            for (int j = 0; j < row.length; j++) {
                result[j][i] = row[j];
            }
        }
        
        return result;
    }
}
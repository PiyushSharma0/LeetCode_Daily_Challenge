// Link: https://leetcode.com/problems/minimum-falling-path-sum/
// Difficulty: Medium
// Time complexity: O(n*m) (m = rows, n = columns)
// Space complexity: O(n*m) (m = rows, n = columns)

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int[m][n];

        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                int up = matrix[i][j] + dp[i - 1][j];

                if(j - 1 >= 0){
                    left = matrix[i][j] + dp[i-1][j-1];
                }
                if(j + 1 < n){
                    right = matrix[i][j] + dp[i-1][j+1];
                }

                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            minSum = Math.min(minSum, dp[n-1][i]);
        }
        
        return minSum;
    }
}
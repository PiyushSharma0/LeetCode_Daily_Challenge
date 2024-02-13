// Link: https://leetcode.com/problems/cherry-pickup-ii/
// Difficulty: Hard
// Time Complexity: O(m * n^2)
// Space Complexity: O(m * n^2)

class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][][] dp = new int[rows][cols][cols];
        
        for (int i = rows - 1; i >= 0; i--) {
            for (int j1 = 0; j1 < cols; j1++) {
                for (int j2 = 0; j2 < cols; j2++) {
                    int cherries = grid[i][j1] + (j1 != j2 ? grid[i][j2] : 0);
                    
                    if (i != rows - 1) {
                        int maxNext = 0;
                        for (int k1 = j1 - 1; k1 <= j1 + 1; k1++) {
                            for (int k2 = j2 - 1; k2 <= j2 + 1; k2++) {
                                if (k1 >= 0 && k1 < cols && k2 >= 0 && k2 < cols) {
                                    maxNext = Math.max(maxNext, dp[i + 1][k1][k2]);
                                }
                            }
                        }
                        cherries += maxNext;
                    }
                    
                    dp[i][j1][j2] = cherries;
                }
            }
        }
        
        return dp[0][0][cols - 1];
    }
}

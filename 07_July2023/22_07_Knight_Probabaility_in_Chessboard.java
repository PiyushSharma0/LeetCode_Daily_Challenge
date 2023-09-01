// Link: https://leetcode.com/problems/knight-probability-in-chessboard/
// Difficulty: Medium
// Time complexity: O(n^2 * k) where n is the size of the chessboard and k is the number of moves
// Space complexity: O(n^2 * k)

class Solution {
    private static final int[][] DIRECTIONS = {
        {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
        {1, -2}, {2, -1}, {2, 1}, {1, 2}
    };
    
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        
        // Initialize probability for the starting cell with k=0 moves.
        dp[row][column][0] = 1.0;
        
        // Calculate probabilities for each move count.
        for (int m = 1; m <= k; m++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : DIRECTIONS) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        
                        // Check if the move is still within the chessboard.
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            dp[i][j][m] += dp[x][y][m - 1] / 8.0;
                        }
                    }
                }
            }
        }
        
        // Sum up the probabilities for the final position at k moves.
        double probability = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                probability += dp[i][j][k];
            }
        }
        
        return probability;
    }
}

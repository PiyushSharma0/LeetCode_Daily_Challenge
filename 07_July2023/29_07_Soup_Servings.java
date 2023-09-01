// Link: https://leetcode.com/problems/soup-servings/
// Difficulty: Medium
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

class Solution {
    public double soupServings(int n) {
        // If n is greater than or equal to 4800 (i.e., 4800 * 25 = 120000 ml), then the probability
        // of reaching zero for both A and B is 1. Therefore, we can return 1.0 as the result directly.
        if (n >= 4800) {
            return 1.0;
        }

        // Call the recursive function to calculate the probability.
        return dfs((n + 24) / 25, (n + 24) / 25);
    }

    // The memoization table to store the calculated probabilities for each state.
    private double[][] memo = new double[4800 / 25][4800 / 25];

    // Recursive function to calculate the probability for each state (a, b).
    private double dfs(int a, int b) {
        // Base case 1: Both A and B are empty, return 0.5.
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        // Base case 2: Soup A is empty, return 1.0.
        if (a <= 0) {
            return 1.0;
        }
        // Base case 3: Soup B is empty, return 0.0.
        if (b <= 0) {
            return 0.0;
        }

        // Check if the probability for the current state is already calculated.
        if (memo[a][b] > 0) {
            return memo[a][b];
        }

        // Calculate the probability for the current state based on the four operations.
        memo[a][b] = 0.25 * (dfs(a - 4, b) +
                            dfs(a - 3, b - 1) +
                            dfs(a - 2, b - 2) +
                            dfs(a - 1, b - 3));

        return memo[a][b];
    }
}

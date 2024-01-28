// Link: https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
// Difficulty: Hard
// Time complexity: O(n^3)
// Space complexity: O(n^2)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        // Precompute the prefix sum for each row
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        // Iterate through all possible pairs of columns (i, j)
        for (int i = 0; i < cols; i++) {
            for (int j = i; j < cols; j++) {
                Map<Integer, Integer> prefixSumCount = new HashMap<>();
                prefixSumCount.put(0, 1);
                int currentSum = 0;

                // Iterate through all rows and calculate the current sum
                for (int k = 0; k < rows; k++) {
                    int colSum = matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    currentSum += colSum;

                    // Check if there is a subarray with sum (currentSum - target)
                    if (prefixSumCount.containsKey(currentSum - target)) {
                        count += prefixSumCount.get(currentSum - target);
                    }

                    // Update the prefix sum count
                    prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
                }
            }
        }

        return count;
    }
}

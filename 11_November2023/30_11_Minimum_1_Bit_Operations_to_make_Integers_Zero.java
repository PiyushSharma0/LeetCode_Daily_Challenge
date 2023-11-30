// Link: https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/
// Difficulty: Hard
// Time complexity: O(logn)
// Space complexity: O(1)

class Solution {
    public int minimumOneBitOperations(int n) {
        // Observation: For any n = 2^k, it needs 2^(k + 1) - 1 operations.
        // This is reversible, meaning 0 -> 2^k also takes 2^(k + 1) - 1 operations.

        // If n is 0, then no operations are needed.
        if (n == 0)
            return 0;

        // Find the largest power of 2 (x) less than or equal to n.
        int x = 1;
        while (x * 2 <= n)
            x <<= 1;

        // Calculate the minimum operations for the XOR operation on n.
        // The expression n ^ (x | x >> 1) determines the cost accordingly.
        // Then, 1100 -> 0100 needs 1 operation. Finally, 0100 -> 0 needs 2^3 - 1 operations.
        return minimumOneBitOperations(n ^ (x | x >> 1)) + 1 + x - 1;
    }
}

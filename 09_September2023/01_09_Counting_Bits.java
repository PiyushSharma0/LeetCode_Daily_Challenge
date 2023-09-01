// Link: https://leetcode.com/problems/counting-bits/
// Difficulty: Easy because of the bit manipulation
// Time complexity: O(n) where n is the input integer
// Space complexity: O(n) where n is the input integer

class Solution {
    public int[] countBits(int n) {
        // Create an array to store the count of 1's for each integer from 0 to n.
        int[] ans = new int[n + 1];

        // Loop through integers from 1 to n.
        for (int i = 1; i <= n; i++) {
            // Count the number of 1's for the current integer i.
            // To do this, we use the previously computed count for i & (i - 1)
            // and add 1 to it. i & (i - 1) clears the least significant 1-bit in i.
            ans[i] = ans[i & (i - 1)] + 1;
        }

        return ans; // Return the array with counts of 1's for each integer.
    }
}

// Link: https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int reductionOperations(int[] nums) {
        // Step 1: Initialize variables and frequency array
        int n = nums.length;
        int[] freq = new int[50001];

        // Step 2: Count the frequency of each unique element in the array
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        // Step 3: Calculate the number of operations needed
        int res = 0, operations = 0;
        for (int i = 50000; i >= 1; i--) {
            if (freq[i] > 0) {
                // Step 4: Accumulate the number of operations and update the result
                operations += freq[i];
                res += operations - freq[i];
            }
        }

        // Step 5: Return the final result
        return res;
    }
}
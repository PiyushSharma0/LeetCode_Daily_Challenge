// Link: https://leetcode.com/problems/binary-trees-with-factors/
// Difficulty: Medium
// Time complexity: O(n^2)
// Space complexity: O(n)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1000000007;
        
        // Step 1: Sort the array in ascending order.
        Arrays.sort(arr);
        
        int n = arr.length;
        
        // Step 2: Initialize an array dp to keep track of the number of binary trees for each element.
        long[] dp = new long[n];
        Arrays.fill(dp, 1);

        // Step 3: Create a mapping of elements to their indices in the sorted array.
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // Step 4: Iterate through the sorted array.
        for (int i = 0; i < n; i++) {
            // Step 5: Iterate through previous elements in the array.
            for (int j = 0; j < i; j++) {
                // Step 6: Check if arr[i] is divisible by arr[j].
                if (arr[i] % arr[j] == 0) {
                    int quotient = arr[i] / arr[j];

                    // Step 7: Check if the quotient exists in indexMap.
                    if (indexMap.containsKey(quotient)) {
                        int k = indexMap.get(quotient);
                        
                        // Step 8: Update dp[i] using the product of dp[j] and dp[k].
                        dp[i] = (dp[i] + dp[j] * dp[k]) % MOD;
                    }
                }
            }
        }

        long totalTrees = 0;
        
        // Step 9: Sum up all the values in the dp array to get the total number of binary trees.
        for (long count : dp) {
            totalTrees = (totalTrees + count) % MOD;
        }

        return (int) totalTrees;
    }
}

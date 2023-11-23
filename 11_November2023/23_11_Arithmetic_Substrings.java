// Link: https://leetcode.com/problems/arithmetic-subarrays/
// Difficulty: Medium
// Time complexity: O(nlogn) where n is the length of the subarray
// Space complexity: O(n) where n is the length of the subarray

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();

        // Iterate through each query
        for (int i = 0; i < l.length; i++) {
            // Extract the subarray specified by the query
            int[] subarray = Arrays.copyOfRange(nums, l[i], r[i] + 1);

            // Check if the subarray can be rearranged to form an arithmetic sequence
            result.add(canFormArithmeticSequence(subarray));
        }

        return result;
    }

    private boolean canFormArithmeticSequence(int[] subarray) {
        // Sort the subarray
        Arrays.sort(subarray);

        // Calculate the common difference
        int diff = subarray[1] - subarray[0];

        // Check if the differences between consecutive elements are the same
        for (int i = 2; i < subarray.length; i++) {
            if (subarray[i] - subarray[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }
}
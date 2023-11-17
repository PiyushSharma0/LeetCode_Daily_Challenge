// Link: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
// Difficulty: Medium
// Time complexity: O(nlogn)
// Space complexity: O(1)

import java.util.Arrays;
 
class Solution {
    public int minPairSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        int n = nums.length;
        int minMaxPairSum = Integer.MIN_VALUE;

        // Pair up the elements
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            // Calculate the pair sum and update the result
            int pairSum = nums[i] + nums[j];
            minMaxPairSum = Math.max(minMaxPairSum, pairSum);
        }

        return minMaxPairSum;
    }
}
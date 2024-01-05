// Link: https://leetcode.com/problems/longest-increasing-subsequence/
// Difficulty: Medium
// Time complexity: O(nlogn)
// Space complexity: O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;  // Variable to keep track of the length of the longest increasing subsequence

        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);

            // If the element is not present, the binarySearch returns -(insertion point) - 1
            if (index < 0) {
                index = -(index + 1);
            }

            // Update the element at the found index with the current number
            dp[index] = num;

            // If the index is equal to the current length, it means we are extending the subsequence
            if (index == len) {
                len++;
            }
        }

        return len;
    }
}
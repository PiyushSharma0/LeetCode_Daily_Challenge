// Link: https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
   public int[] getSumAbsoluteDifferences(int[] nums) {
        // Calculate the total sum of the array
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        // Initialize left and right sums
        int left = 0;
        int right = sum;

        // Initialize the result array
        int[] result = new int[nums.length];

        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            // Update right sum by subtracting the current element
            right -= n;

            // Calculate the sum of absolute differences using the given formula
            result[i] = n * i - left + right - n * (nums.length - i - 1);

            // Update left sum by adding the current element
            left += n;
        }

        return result;
    }
}
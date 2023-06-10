// Link: https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
// Difficulty: Medium
// Time complexity: O(log(maxSum - n))
// Space complexity: O(1)

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 0, right = maxSum - n; // Set the initial left and right boundaries

        while (left < right) {
            int middle = (left + right + 1) / 2; // Calculate the middle value

            // Check if it's possible to construct the array with the given middle value
            if (isPossible(n, index, maxSum - n, middle))
                left = middle; // Update the left boundary
            else
                right = middle - 1; // Update the right boundary
        }
        
        return left + 1; // Return the maximum value at the given index
    }

    private boolean isPossible(int n, int index, int maxSum, int value) {
        int leftValue = Math.max(value - index, 0); // Calculate the value on the left side of the index
        int rightValue = Math.max(value - ((n - 1) - index), 0); // Calculate the value on the right side of the index

        long sumBefore = (long) (value + leftValue) * (value - leftValue + 1) / 2; // Calculate the sum before the index
        long sumAfter = (long) (value + rightValue) * (value - rightValue + 1) / 2; // Calculate the sum after the index

        return sumBefore + sumAfter - value <= maxSum; // Check if the sum is within the maxSum
    }
}

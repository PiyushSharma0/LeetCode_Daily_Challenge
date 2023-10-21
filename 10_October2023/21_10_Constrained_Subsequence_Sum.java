// Link: https://leetcode.com/problems/constrained-subsequence-sum/
// Difficulty: Hard
// Time complexity: O(N)
// Space complexity: O(N)

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        int maxSum = nums[0];

        for (int i = 0; i < n; i++) {
            // Pop elements from the front of the deque if they are out of the range k.
            while (!deque.isEmpty() && i - deque.peekFirst() > k) {
                deque.pollFirst();
            }

            // Calculate the current dynamic programming state (maximum sum ending at i).
            dp[i] = nums[i] + (deque.isEmpty() ? 0 : Math.max(0, dp[deque.peekFirst()]));

            // Pop elements from the back of the deque if they are less than the current state dp[i].
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current index to the deque.
            deque.offerLast(i);

            // Update the maximum sum found so far.
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}

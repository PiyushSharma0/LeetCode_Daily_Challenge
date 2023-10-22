// Link: https://leetcode.com/problems/maximum-score-of-a-good-subarray/
// Difficulty: Hard
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
  public int maximumScore(int[] nums, int k) {
    int ans = 0; // Initialize the answer variable to store the maximum score.
    Deque<Integer> stack = new ArrayDeque<>(); // Create a stack using Deque to help with calculations.

    for (int i = 0; i <= nums.length; ++i) { // Iterate through the elements of the 'nums' array, including an additional loop to process the remaining elements.
      while (!stack.isEmpty() && (i == nums.length || nums[stack.peek()] > nums[i])) {
        // This loop runs when the current element (i) is greater than the previous elements in the stack or when we reach the end of the array.

        final int h = nums[stack.pop()]; // Pop the element from the stack and store its height in 'h'.
        final int w = stack.isEmpty() ? i : i - stack.peek() - 1; // Calculate the width 'w' based on the current position and the element popped from the stack.

        if ((stack.isEmpty() || stack.peek() + 1 <= k) && i - 1 >= k) {
          // Check if the current range is valid for the calculation. It should have a starting position (k) less than or equal to the index of the first element in the stack,
          // and the ending position (i-1) should be greater than or equal to 'k'.

          ans = Math.max(ans, h * w); // Calculate the score (height times width) and update 'ans' if it's greater than the previous maximum.
        }
      }
      stack.push(i); // Push the current index onto the stack.
    }

    return ans; // Return the maximum score.
  }
}

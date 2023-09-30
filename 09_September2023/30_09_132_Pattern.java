// Link: https://leetcode.com/problems/132-pattern/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        
        int[] minLeft = new int[n]; // Array to store the minimum element to the left of each element
        minLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], nums[i]);
        }
        
        Stack<Integer> stack = new Stack<>();
        for (int j = n - 1; j >= 0; j--) {
            // If the current element is greater than the minimum element to its left,
            // then it can be a potential "132" pattern's nums[j] (the '2' in 132).
            if (nums[j] > minLeft[j]) {
                // Now, we look for a candidate for nums[i] (the '1' in 132).
                while (!stack.isEmpty() && stack.peek() <= minLeft[j]) {
                    stack.pop();
                }
                // If we find a candidate, return true.
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                // Otherwise, push the current element onto the stack as a potential "3" in 132.
                stack.push(nums[j]);
            }
        }
        
        return false;
    }
}

// Link: https://leetcode.com/problems/sliding-window-maximum/
// Difficulty: Hard but not that hard if you know the trick of using a deque
// Time complexity: O(n) where n is the size of the input array
// Space complexity: O(k) where k is the size of the sliding window

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        
        int[] result = new int[n - k + 1];
        int ri = 0; // Index for the result array
        
        // Deque to store indices of elements in the sliding window
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current sliding window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            
            // Remove smaller elements from the back of the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add the current index to the back of the deque
            deque.offer(i);
            
            // If the current window is of size k, add the maximum to the result
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }
        
        return result;
    }  
}

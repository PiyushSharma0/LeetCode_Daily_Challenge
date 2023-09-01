// Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int count = 0; // Variable to track the count of 1s in the current subarray
        int max = 0; // Maximum length of subarray with at most one 0
        
        while (right < nums.length) {
            if (nums[right] == 1) {
                count++; // Increment count if the current element is 1
            }
            
            // If the number of zeros (right - left + 1 - count) exceeds 1, move the left pointer
            while (right - left + 1 - count > 1) {
                if (nums[left] == 1) {
                    count--; // Decrement count if the element being removed (left pointer) is 1
                }
                
                left++; // Move the left pointer to the right
            }
            
            max = Math.max(max, right - left); // Update the maximum length of subarray
            
            right++; // Move the right pointer to the right
        }
        
        return max; // Return the maximum length of subarray with at most one 0
    }
}

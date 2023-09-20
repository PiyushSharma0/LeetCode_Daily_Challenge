// Link: https://leetcode.com/problems/find-the-duplicate-number/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize the slow and fast pointers to the first element.
        int slow = nums[0];
        int fast = nums[0];
        
        // Phase 1: Find the intersection point of the two pointers.
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Phase 2: Find the entrance to the cycle.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow; // The duplicate number is found.
    }
}
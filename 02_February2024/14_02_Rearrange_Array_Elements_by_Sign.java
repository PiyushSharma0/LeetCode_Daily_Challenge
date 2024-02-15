// Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n), if we count the resultant array otherwise O(1)

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0, neg = 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        
        return ans;
    }
}

// Link: https://leetcode.com/problems/summary-ranges/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        if (nums.length == 0) {
            return result;
        }
        
        int start = nums[0]; // Initialize the start of the current range
        
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                // Found the end of the current range
                
                if (start == nums[i - 1]) {
                    result.add(Integer.toString(start)); // Range has only one element
                } else {
                    result.add(start + "->" + nums[i - 1]); // Range has more than one element
                }
                
                if (i < nums.length) {
                    start = nums[i]; // Start a new range
                }
            }
        }
        
        return result;
    }
}

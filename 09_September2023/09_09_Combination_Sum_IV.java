// Link: https://leetcode.com/problems/combination-sum-iv/
// Difficulty: Medium
// Time complexity: O(n * k) where n is the target and k is the length of the nums array
// Space complexity: O(n)

class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];  
        return countCombinations(dp, nums, target);
    }

    // Recursive function to count combinations that add up to the target
    public int countCombinations(Integer[] dp, int[] nums, int target) {
        // Base case: If the target is 0, there is one valid combination.
        if (target == 0) {
            return 1;
        }
        // Base case: If the target becomes negative, there are no valid combinations.
        if (target < 0) {
            return 0;
        } 

        // If we have already computed the result for this target, return it.
        if (dp[target] != null) {
            return dp[target];
        }

        int combinations = 0;
        // Iterate through the numbers in the nums array.
        for (int i = 0; i < nums.length; i++) {
            // Recursively find combinations by subtracting the current number from the target.
            combinations += countCombinations(dp, nums, target - nums[i]);
        }

        // Store the result in dp for future reference and return it.
        dp[target] = combinations;
        return dp[target];
    }
}

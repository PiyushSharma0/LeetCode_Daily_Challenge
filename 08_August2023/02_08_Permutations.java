// Link: https://leetcode.com/problems/permutations/
// Difficulty: Medium
// Time complexity: O(n * n!) where n is the length of the input array
// Space complexity: O(n * n!) where n is the length of the input array

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // List to store all permutations
        List<Integer> current = new ArrayList<>(); // List to store the current permutation being generated
        boolean[] used = new boolean[nums.length]; // Array to keep track of used elements
        
        // Start the backtracking process
        backtrack(nums, used, current, result);
        
        return result;
    }
    
    // Backtracking function to generate permutations
    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // If the current permutation's size is equal to the length of the input array
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Add a copy of the current permutation to the result
            return;
        }
        
        // Explore all possibilities by iterating through the elements in the nums array
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // If the element hasn't been used in the current permutation
                current.add(nums[i]); // Add the element to the current permutation
                used[i] = true; // Mark the element as used
                
                // Recursive call to generate permutations with the current element included
                backtrack(nums, used, current, result);
                
                // Backtrack by removing the last element from the current permutation and marking it as unused
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}

// Link: https://leetcode.com/problems/combinations/
// Difficulty: Medium
// Time complexity: O(k * C(n, k)) where C(n, k) = n! / (k! * (n - k)!) is the number of combinations.
// Space complexity: O(C(n, k)) since we need to store C(n, k) combinations in the result list.

import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return result; // Return an empty list for invalid input.
        }

        List<Integer> currentCombination = new ArrayList<>();
        backtrack(1, n, k, currentCombination, result);

        return result;
    }

    // Recursive backtracking function to find combinations of k elements from the range [1, n].
    private void backtrack(int start, int n, int k, List<Integer> currentCombination, List<List<Integer>> result) {
        // Base case: If the current combination reaches the desired length k, add it to the result.
        if (currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Explore all possible choices for the next element in the combination.
        for (int i = start; i <= n; i++) {
            currentCombination.add(i); // Choose the current element and add it to the combination.
            // Recursively call the function with the updated starting point (i + 1).
            backtrack(i + 1, n, k, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1); // Backtrack by removing the last element.
        }
    }
}

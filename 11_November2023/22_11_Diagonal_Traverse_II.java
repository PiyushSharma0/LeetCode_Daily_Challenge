// Link: https://leetcode.com/problems/diagonal-traverse-ii/
// Difficulty: Medium
// Time complexity: O(N)
// Space complexity: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> keyToNums = new HashMap<>(); // Key = row + col
        int maxKey = 0;

        // Iterate through the 2D list and populate the map based on diagonal elements
        for (int i = 0; i < nums.size(); ++i)
            for (int j = 0; j < nums.get(i).size(); ++j) {
                final int key = i + j;
                keyToNums.putIfAbsent(key, new ArrayList<>());
                keyToNums.get(key).add(nums.get(i).get(j));
                maxKey = Math.max(key, maxKey);
            }

        // Iterate through the map in reverse order and add elements to the result list
        for (int i = 0; i <= maxKey; ++i) {
            List<Integer> diagonalElements = keyToNums.get(i);
            for (int j = diagonalElements.size() - 1; j >= 0; --j)
                ans.add(diagonalElements.get(j));
        }

        // Convert the result list to an array
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}

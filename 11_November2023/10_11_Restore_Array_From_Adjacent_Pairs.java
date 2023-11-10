// Link: https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();

        // Build adjacency map
        for (int[] pair : adjacentPairs) {
            adjacencyMap.putIfAbsent(pair[0], new ArrayList<>());
            adjacencyMap.putIfAbsent(pair[1], new ArrayList<>());
            adjacencyMap.get(pair[0]).add(pair[1]);
            adjacencyMap.get(pair[1]).add(pair[0]);
        }

        // Find the starting point (a number that only appears once in the adjacency map)
        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        // Reconstruct the array
        int[] result = new int[adjacentPairs.length + 1];
        Set<Integer> visited = new HashSet<>();
        result[0] = start;
        visited.add(start);

        for (int i = 1; i < result.length; i++) {
            List<Integer> neighbors = adjacencyMap.get(result[i - 1]);
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    result[i] = neighbor;
                    visited.add(neighbor);
                    break;
                }
            }
        }

        return result;
    }
}


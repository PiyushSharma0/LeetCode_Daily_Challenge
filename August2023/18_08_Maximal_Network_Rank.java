// Link: https://leetcode.com/problems/maximal-network-rank/
// Difficulty: Medium
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // Step 1: Create an adjacency matrix to represent city connectivity.
        int[][] adjacencyMatrix = new int[n][n];
        
        // Step 2: Create an array to store direct road counts for each city.
        int[] directRoadCounts = new int[n];
        
        // Step 3: Update adjacency matrix and direct road counts array based on roads.
        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            adjacencyMatrix[city1][city2] = 1;
            adjacencyMatrix[city2][city1] = 1; // Since roads are bidirectional
            directRoadCounts[city1]++;
            directRoadCounts[city2]++;
        }
        
        // Step 4: Calculate maximal network rank by considering all pairs of cities.
        int maximalNetworkRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate network rank for the pair (i, j) by summing direct road counts
                // and subtracting 1 if there is a direct road between cities i and j.
                int networkRank = directRoadCounts[i] + directRoadCounts[j] - adjacencyMatrix[i][j];
                maximalNetworkRank = Math.max(maximalNetworkRank, networkRank);
            }
        }
        
        // Step 5: Return the calculated maximal network rank.
        return maximalNetworkRank;
    }
}
// Link: https://leetcode.com/problems/min-cost-to-connect-all-points/
// Difficulty: Medium
// Time complexity: O(n^2 log n) where n is the number of points
// Space complexity: O(n^2) where n is the number of points

import java.util.*;

class Solution {
    // Helper class to represent an edge between two points and its weight.
    private class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    // Helper function to find the parent of a node in the disjoint-set.
    private int findParent(int[] parent, int node) {
        if (parent[node] == node)
            return node;
        return parent[node] = findParent(parent, parent[node]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();

        // Calculate the Manhattan distances and create edges for all pairs of points.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, distance));
            }
        }

        // Sort edges by their weights.
        edges.sort(Comparator.comparingInt(e -> e.cost));

        // Initialize parent array for the disjoint-set.
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int minCost = 0;
        int edgeCount = 0;

        // Kruskal's algorithm: Connect the points with the minimum cost edges.
        for (Edge edge : edges) {
            int parent1 = findParent(parent, edge.from);
            int parent2 = findParent(parent, edge.to);

            if (parent1 != parent2) {
                // Union the two sets and add the edge to the minimum spanning tree.
                parent[parent1] = parent2;
                minCost += edge.cost;
                edgeCount++;
            }

            // Stop when all points are connected.
            if (edgeCount == n - 1) {
                break;
            }
        }

        return minCost;
    }
}
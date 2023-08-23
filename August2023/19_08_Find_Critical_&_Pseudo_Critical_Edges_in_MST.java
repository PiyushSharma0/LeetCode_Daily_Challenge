// Link: https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/
// Difficulty: Hard because of UnionFind
// Time complexity: O(ElogE + E^2) where E is the number of edges
// Space complexity: O(E)

import java.util.*;

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int numEdges = edges.length;
        int[][] edgesWithIndices = new int[numEdges][4]; // [src, dest, weight, index]
        
        // Create an array with edges and their indices for sorting
        for (int i = 0; i < numEdges; i++) {
            edgesWithIndices[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }
        Arrays.sort(edgesWithIndices, (a, b) -> Integer.compare(a[2], b[2])); // Sort edges by weight

        // Build the Minimum Spanning Tree (MST) using Kruskal's algorithm
        int mstWeight = buildMST(n, edgesWithIndices, -1, -1);

        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();

        // Iterate through each edge to identify critical and pseudo-critical edges
        for (int i = 0; i < numEdges; i++) {
            int weightWithoutEdge = buildMST(n, edgesWithIndices, i, -1);
            if (weightWithoutEdge > mstWeight) {
                criticalEdges.add(edgesWithIndices[i][3]); // Add index of critical edge
            } else {
                int weightWithEdge = buildMST(n, edgesWithIndices, -1, i);
                if (weightWithEdge == mstWeight) {
                    pseudoCriticalEdges.add(edgesWithIndices[i][3]); // Add index of pseudo-critical edge
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(criticalEdges); // List of critical edges
        result.add(pseudoCriticalEdges); // List of pseudo-critical edges
        return result;
    }

    // Function to build Minimum Spanning Tree and return its weight
    private int buildMST(int n, int[][] edges, int excludedEdge, int includedEdge) {
        UnionFind uf = new UnionFind(n);
        int weight = 0;

        if (includedEdge != -1) {
            uf.union(edges[includedEdge][0], edges[includedEdge][1]);
            weight += edges[includedEdge][2]; // Add weight of included edge
        }

        // Iterate through edges to build MST
        for (int i = 0; i < edges.length; i++) {
            if (i == excludedEdge || i == includedEdge) {
                continue;
            }
            if (uf.union(edges[i][0], edges[i][1])) {
                weight += edges[i][2]; // Add weight of included edge
            }
        }

        return uf.getCount() == 1 ? weight : Integer.MAX_VALUE; // Return MST weight if connected, otherwise return MAX_VALUE
    }

    // UnionFind data structure for tracking connected components
    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false; // Same component
            }
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }

        int getCount() {
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    count++;
                }
            }
            return count; // Return the count of connected components
        }
    }
}

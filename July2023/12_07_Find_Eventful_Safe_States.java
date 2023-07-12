// Link: https://leetcode.com/problems/find-eventual-safe-states/
// Difficulty: Medium
// Time complexity: O(n + e) where n is the number of nodes and e is the number of edges
// Space complexity: O(n) where n is the number of nodes

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        int n = graph.length;
        int[] color = new int[n];

        // Iterate through each node in the graph
        for (int i = 0; i < n; i++) {
            // If the node is eventually safe (no cycles), add it to the safeNodes list
            if (dfs(graph, i, color)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean dfs(int[][] graph, int node, int[] color) {
        // If the node has been visited and marked as safe (color[node] = 2), return true
        if (color[node] > 0) {
            return color[node] == 2;
        }

        // Mark the node as currently being visited (color[node] = 1)
        color[node] = 1;

        // Explore each neighbor of the current node
        for (int nextNode : graph[node]) {
            // If the neighbor is already marked as safe (color[nextNode] = 2), skip it
            if (color[nextNode] == 2) {
                continue;
            }

            // If the neighbor is currently being visited (color[nextNode] = 1) or
            // there is a cycle in its subtree, return false
            if (color[nextNode] == 1 || !dfs(graph, nextNode, color)) {
                return false;
            }
        }

        // Mark the node as safe (color[node] = 2)
        color[node] = 2;

        // The node is eventually safe
        return true;
    }
}

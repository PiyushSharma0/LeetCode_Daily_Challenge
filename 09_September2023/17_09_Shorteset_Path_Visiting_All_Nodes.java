// Link: https://leetcode.com/problems/shortest-path-visiting-all-nodes/
// Difficulty: Hard
// Time complexity: O(n * 2^n)
// Space complexity: O(n * 2^n)

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;  // Number of nodes in the graph
        int goal = (1 << n) - 1;  // Goal state where all nodes are visited

        int ans = 0;  // Initialize the answer
        Queue<int[]> q = new LinkedList<>();  // Queue to perform BFS
        boolean[][] seen = new boolean[n][1 << n];  // Keep track of visited states

        // Initialize the queue with starting states for each node
        for (int i = 0; i < n; ++i)
            q.offer(new int[]{i, 1 << i});  // (node, state)

        while (!q.isEmpty()) {
            int sz = q.size();  // Number of nodes at the current level
            for (int i = 0; i < sz; i++) {
                int[] pair = q.poll();  // Dequeue a node and its state
                int u = pair[0];  // Current node
                int state = pair[1];  // Current state

                if (state == goal)
                    return ans;  // If all nodes are visited, return the answer
                if (seen[u][state])
                    continue;  // Skip if this state has been visited before
                seen[u][state] = true;  // Mark the current state as visited

                // Add neighbors to the queue with updated state
                for (int v : graph[u])
                    q.offer(new int[]{v, state | (1 << v)});
            }
            ++ans;  // Increment the path length
        }

        return -1;  // If no valid path is found, return -1
    }
}

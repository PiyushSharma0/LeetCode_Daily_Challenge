// Link: https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/
// Difficulty: Hard because of Topological Sorting
// Time complexity: O(V + E) where V is the number of vertices and E is the number of edges
// Space complexity: O(V + E)

import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
    // Create an array of lists to represent the graph
    List<Integer>[] graph = new List[n + m];
    int[] inDegree = new int[n + m]; // Array to store in-degrees of nodes

    for (int i = 0; i < graph.length; ++i)
      graph[i] = new ArrayList<>();

    // Build the graph by mapping k-th group to k + n imaginary node
    for (int i = 0; i < group.length; ++i) {
      if (group[i] == -1)
        continue;
      graph[group[i] + n].add(i); // Add directed edge from group node to item node
      ++inDegree[i]; // Increase in-degree of item node
    }

    // Add edges based on dependencies (beforeItems)
    for (int i = 0; i < beforeItems.size(); ++i)
      for (final int b : beforeItems.get(i)) {
        final int u = group[b] == -1 ? b : group[b] + n; // Map group to node index
        final int v = group[i] == -1 ? i : group[i] + n; // Map group to node index
        
        if (u == v) { // If both items are in the same group
          graph[b].add(i); // Add directed edge from "b" to "i"
          ++inDegree[i];    // Increase in-degree of node "i"
        } else {
          graph[u].add(v);  // Add directed edge from "u" to "v"
          ++inDegree[v];    // Increase in-degree of node "v"
        }
      }

    // Perform Topological Sorting
    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < n + m; ++i)
      if (inDegree[i] == 0) // If in-degree is 0 (unvisited)
        dfs(graph, i, inDegree, n, ans);

    // If all nodes are visited and added to the answer, return the result
    return ans.size() == n ? ans.stream().mapToInt(Integer::intValue).toArray() : new int[] {};
  }

  // Depth-first Search to traverse and mark visited nodes
  private void dfs(List<Integer>[] graph, int u, int[] inDegree, int n, List<Integer> ans) {
    if (u < n)
      ans.add(u); // Add item node to the result

    inDegree[u] = -1; // Mark the node as visited

    // Traverse adjacent nodes
    for (final int v : graph[u])
      if (--inDegree[v] == 0) // Decrease in-degree of adjacent node
        dfs(graph, v, inDegree, n, ans);
  }
}

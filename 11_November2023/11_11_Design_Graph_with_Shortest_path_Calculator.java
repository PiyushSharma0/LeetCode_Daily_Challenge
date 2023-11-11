// Link:https://leetcode.com/problems/design-graph-with-shortest-path-calculator/description/
// Difficulty: Hard
// Time Complexity: O(nlogn)
// Space Complexity: O(n)

import java.util.*;

class Graph {
    // Adjacency list to represent the graph
    private Map<Integer, List<int[]>> adjacencyList;

    // Constructor to initialize the graph with nodes and edges
    public Graph(int n, int[][] edges) {
        adjacencyList = new HashMap<>();
        // Populate the adjacency list based on the given edges
        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
    }

    // Method to add a new edge to the graph
    public void addEdge(int[] edge) {
        // Add the edge to the adjacency list
        adjacencyList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
    }

    // Method to find the shortest path from node1 to node2
    public int shortestPath(int node1, int node2) {
        // Priority queue to keep track of the nodes and their costs
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{node1, 0}); // Start with node1 and cost 0

        // Set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();

        // Dijkstra's algorithm
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            // If the destination node is reached, return the cost
            if (currentNode == node2) {
                return currentCost;
            }

            // Skip if the node is already visited
            if (visited.contains(currentNode)) {
                continue;
            }

            visited.add(currentNode);

            // Explore neighbors and update the priority queue
            if (adjacencyList.containsKey(currentNode)) {
                for (int[] neighbor : adjacencyList.get(currentNode)) {
                    int nextNode = neighbor[0];
                    int nextCost = currentCost + neighbor[1];
                    minHeap.offer(new int[]{nextNode, nextCost});
                }
            }
        }

        return -1; // No path found
    }
}

// Link: https://leetcode.com/problems/path-with-maximum-probability/
// Difficulty: Medium
// Time complexity: O(E + V) where E is the number of edges and V is the number of vertices
// Space complexity: O(E + V) where E is the number of edges and V is the number of vertices

import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create a graph using adjacency list representation
        Map<Integer, List<double[]>> graph = new HashMap<>();
        
        // Iterate over the edges array to populate the graph
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            
            // Add the vertices and their corresponding probabilities to the graph
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            
            // Add the edge and its success probability to both vertices' adjacency lists
            graph.get(edge[0]).add(new double[]{edge[1], succProb[i]});
            graph.get(edge[1]).add(new double[]{edge[0], succProb[i]});
        }
        
        // Create an array to store the probabilities for each node
        double[] prob = new double[n];
        prob[start] = 1; // Set the probability of the start node to 1
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // Add the start node to the queue
        
        // Perform breadth-first search (BFS) on the graph
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            // Iterate over the adjacent nodes of the current node
            for (double[] next : graph.getOrDefault(curr, new ArrayList<>())) {
                // Calculate the probability of reaching the next node
                double nextProb = prob[curr] * next[1];
                
                // If the calculated probability is greater than the existing probability for the next node,
                // update the probability and add the next node to the queue for further exploration
                if (nextProb > prob[(int) next[0]]) {
                    prob[(int) next[0]] = nextProb;
                    queue.offer((int) next[0]);
                }
            }
        }
        
        // Return the probability of reaching the end node
        return prob[end];
    }
}

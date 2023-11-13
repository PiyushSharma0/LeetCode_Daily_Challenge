// Link: https://leetcode.com/problems/bus-routes/
// Difficulty: Hard
// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // If source and target are the same, no need to take any bus
        if (source == target) {
            return 0;
        }

        // Map to store the buses that stop at each bus stop
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();

        // Populate the stopToRoutes map
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        // Queue for BFS, Set to track visited stops, Set to track visited routes
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();

        // Initialize BFS with the source bus stop
        queue.offer(source);
        visitedStops.add(source);
        int buses = 0; // Variable to track the number of buses taken

        // BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                List<Integer> currentRoutes = stopToRoutes.get(currentStop);

                // Check each bus route that stops at the current bus stop
                for (int route : currentRoutes) {
                    // If the route is already visited, skip it
                    if (visitedRoutes.contains(route)) {
                        continue;
                    }

                    visitedRoutes.add(route); // Mark the route as visited

                    // Check each next bus stop on the route
                    for (int nextStop : routes[route]) {
                        // If the stop is already visited, skip it
                        if (visitedStops.contains(nextStop)) {
                            continue;
                        }

                        // If the target is reached, return the number of buses taken
                        if (nextStop == target) {
                            return buses + 1;
                        }

                        // Mark the next stop as visited and enqueue it for further exploration
                        visitedStops.add(nextStop);
                        queue.offer(nextStop);
                    }
                }
            }
            buses++; // Increment the number of buses taken after exploring each level
        }

        return -1; // If not possible to reach the target
    }
}

// Link: https://leetcode.com/problems/reconstruct-itinerary/
// Difficulty: Hard but not that hard
// Time complexity: O(n) where n is the number of tickets
// Space complexity: O(n) where n is the number of tickets

import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> itinerary = new ArrayList<>();

        // Build the graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        // Perform DFS starting from JFK
        dfs("JFK", graph, itinerary);

        // Reverse the result to get the correct order
        Collections.reverse(itinerary);

        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport, graph, itinerary);
        }

        // Add the airport to the itinerary in reverse order
        itinerary.add(airport);
    }
}

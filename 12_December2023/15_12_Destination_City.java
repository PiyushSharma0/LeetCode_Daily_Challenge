// Link: https://leetcode.com/problems/destination-city/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> startingCities = new HashSet<>();
        Set<String> destinationCities = new HashSet<>();

        // Iterate through the paths and populate the sets
        for (List<String> path : paths) {
            startingCities.add(path.get(0));
            destinationCities.add(path.get(1));
        }

        // Find the destination city by finding the city in destinationCities but not in startingCities
        for (String city : destinationCities) {
            if (!startingCities.contains(city)) {
                return city;
            }
        }

        // The function is guaranteed to have exactly one destination city, so this line is unreachable
        return null;
    }
}
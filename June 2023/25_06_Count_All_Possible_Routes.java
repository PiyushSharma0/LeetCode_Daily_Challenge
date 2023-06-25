// Link: https://leetcode.com/problems/count-all-possible-routes/
// Difficulty: Hard
// Time Complexity: O(n * fuel) where n is the number of locations and fuel is the maximum fuel
// Space Complexity: O(n * fuel) where n is the number of locations and fuel is the maximum fuel

import java.util.Arrays;

class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        // Create a 2D array to store the computed results
        int[][] dp = new int[locations.length][fuel + 1];
        
        // Initialize the array with -1 to indicate that the result is not computed yet
        for (int i = 0; i < locations.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        // Call the recursive function and return the result
        return dfs(locations, start, finish, fuel, dp);
    }

    private int dfs(int[] locations, int start, int finish, int fuel, int[][] dp) {
        // If the result is already computed, return it from the array
        if (dp[start][fuel] != -1) {
            return dp[start][fuel];
        }
        
        int res = 0;
        
        // If the current location is the destination, increment the result
        if (start == finish) {
            res++;
        }
        
        // Iterate over all possible next locations
        for (int i = 0; i < locations.length; i++) {
            // Skip the current location and check if there is enough fuel to travel to the next location
            if (i != start && fuel >= Math.abs(locations[start] - locations[i])) {
                // Recursively calculate the number of routes from the next location
                // Update the fuel and add the result to the current result
                res = (res + dfs(locations, i, finish, fuel - Math.abs(locations[start] - locations[i]), dp)) % 1000000007;
            }
        }
        
        // Store the computed result in the array for future use
        dp[start][fuel] = res;
        
        // Return the result
        return res;
    }
}

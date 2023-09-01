// Link: https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
// Difficulty: Hard
// Time complexity: O(2^N * N)
// Space complexity: O(N)

import java.util.Arrays;

class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] in = new int[n];  // Array to track incoming requests for each building
        int[] out = new int[n]; // Array to track outgoing requests for each building
        int ans = 0; // Variable to store the maximum number of valid requests
        
        // Count the incoming and outgoing requests for each building
        for (int[] req : requests) {
            out[req[0]]++; // Increment outgoing requests for the source building
            in[req[1]]++;  // Increment incoming requests for the destination building
        }
        
        // Generate all possible subsets of requests
        for (int i = 0; i < (1 << requests.length); i++) {
            int[] tempIn = new int[n];  // Temporary array to track incoming requests
            int[] tempOut = new int[n]; // Temporary array to track outgoing requests
            int count = 0; // Count of valid requests in the subset
            
            // Check which requests are included in the current subset
            for (int j = 0; j < requests.length; j++) {
                if ((i & (1 << j)) != 0) {
                    tempOut[requests[j][0]]++; // Increment outgoing requests in the subset for the source building
                    tempIn[requests[j][1]]++;  // Increment incoming requests in the subset for the destination building
                    count++; // Increment the count of valid requests
                }
            }
            
            // Check if the subset is valid, i.e., incoming requests match outgoing requests for all buildings
            if (Arrays.equals(tempIn, tempOut)) {
                ans = Math.max(ans, count); // Update the maximum count if necessary
            }
        }
        
        return ans; // Return the maximum count of valid requests
    }
}

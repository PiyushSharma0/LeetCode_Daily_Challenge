// Link: https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
// Difficulty: Medium
// Time complexity: O(n log 1e7) because we are using binary search
// Space complexity: O(1) because we are not using any extra space

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        // Check if it is even possible to reach the office on time
        if (dist.length - 1 + 1e-7 > hour) {
            return -1;
        }
        
        int left = 1;
        int right = (int) 1e7; // Set the upper bound for the binary search
        
        while (left <= right) {
            int mid = (left + right) >>> 1; // Calculate the middle speed

            // Check if the current middle speed satisfies the time constraint
            if (isCheck(dist, mid, hour)) {
                left = mid + 1; // Search for a higher speed
            } else {
                right = mid - 1; // Search for a lower speed
            }
        }
        
        return left; // Return the minimum positive integer speed that satisfies the time constraint
    }

    private boolean isCheck(int[] dist, int mid, double hour) {
        int count = 0;
        int n = dist.length;

        // Calculate the total number of hours taken for each train ride at the given speed (mid)
        for (int i = 0; i < n - 1; i++) {
            count += (dist[i] + (mid - 1)) / mid; // ceil(dist[i]/mid)
        }

        double dCount = count + (1d * dist[n - 1]) / mid; // Add the time taken for the last train ride
        
        return dCount > hour; // Return true if the total time exceeds the target hour, false otherwise
    }
}

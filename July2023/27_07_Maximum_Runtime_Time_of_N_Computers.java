// Link: https://leetcode.com/problems/maximum-running-time-of-n-computers/
// Difficulty: Hard
// Time complexity: O(NlogM) where N is the number of batteries and M is the maximum battery running time
// Space complexity: O(1)

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int batteryCount = batteries.length;
        if (batteryCount < n) {
            return 0; // Not enough batteries to power all computers
        }

        long left = 0, right = 0;
        for (int battery : batteries) {
            right += battery; // Calculate the sum of all battery running times
        }
        right /= n; // Calculate the average running time per computer

        long result = 0;

        // Perform binary search to find the maximum possible running time
        // that can be achieved for all n computers
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (possible(n, batteries, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Helper function to check if it is possible to achieve the target running time
    // for all n computers using the given batteries
    private boolean possible(int n, int[] batteries, long target) {
        long totalTarget = target * n; // Calculate the total target running time for all computers
        for (int battery : batteries) {
            totalTarget -= Math.min(target, battery); // Subtract the actual battery running time from the target
        }
        return totalTarget <= 0; // Return true if the total target is less than or equal to zero
    }
}
// Link: https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
// Difficulty: Medium
// Time Complexity: O(nlogn)
// Space Complexity: O(n)

import java.util.Arrays;

class Solution {
     public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTimes = new int[n];

        for (int i = 0; i < n; i++) {
            // Calculate the time it takes for each monster to reach the city
            arrivalTimes[i] = (dist[i] + speed[i] - 1) / speed[i]; // Round up to the nearest minute
        }

        // Sort monsters based on their arrival times
        Arrays.sort(arrivalTimes);

        int eliminatedMonsters = 0;
        int time = 0;

        for (int i = 0; i < n; i++) {
            // Check if there's enough time to charge the weapon before the monster arrives
            if (time >= arrivalTimes[i]) {
                break;
            }

            // Eliminate the monster and charge the weapon for 1 minute
            eliminatedMonsters++;
            time++;
        }

        return eliminatedMonsters;
    }
}
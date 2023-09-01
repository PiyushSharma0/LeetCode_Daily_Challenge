// Link: https://leetcode.com/problems/find-the-highest-altitude/
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0; // Variable to store the maximum altitude
        int currentAltitude = 0; // Variable to track the current altitude
        
        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i]; // Update the current altitude by adding the gain
            
            // Check if the current altitude is greater than the maximum altitude
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude; // Update the maximum altitude
            }
        }
        
        return maxAltitude; // Return the maximum altitude
    }
}

// Link: https://leetcode.com/problems/path-crossing/
// Difficulty: Easy
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.HashSet;

class Solution {
    public boolean isPathCrossing(String path) {
        // Initialize the current position.
        int x = 0, y = 0;

        // Create a HashSet to store visited points.
        HashSet<String> visited = new HashSet<>();
        visited.add(x + "," + y);

        // Traverse the path and update the position.
        for (char direction : path.toCharArray()) {
            switch (direction) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            // Check if the current position has been visited before.
            if (!visited.add(x + "," + y)) {
                return true;
            }
        }

        // The path does not cross itself.
        return false;
    }
}
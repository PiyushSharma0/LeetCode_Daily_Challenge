// Link: https://leetcode.com/problems/asteroid-collision/
// Difficulty: Medium but I think it's easy
// Time complexity: O(n)
// Space complexity: O(n)

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean asteroidDestroyed = false;

            // Check for collisions while the current asteroid is moving to the left (negative direction).
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int topAsteroid = stack.pop();

                // Determine which asteroid explodes based on their absolute values.
                if (Math.abs(topAsteroid) > Math.abs(asteroid)) {
                    asteroidDestroyed = true;
                    stack.push(topAsteroid);
                    break; // The current asteroid will be destroyed, no need to proceed further.
                } else if (Math.abs(topAsteroid) == Math.abs(asteroid)) {
                    asteroidDestroyed = true;
                    break; // Both asteroids are destroyed.
                }
            }

            // If the current asteroid didn't collide or it destroyed other asteroids, push it to the stack.
            if (!asteroidDestroyed) {
                stack.push(asteroid);
            }
        }

        // Convert the stack to the resulting array.
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}

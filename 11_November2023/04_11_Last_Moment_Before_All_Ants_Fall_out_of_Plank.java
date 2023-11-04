// Link: https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
// Difficulty: Medium but easy
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTimeToLeft = 0;
        int maxTimeToRight = 0;

        // Find the maximum time it takes for ants moving to the left to fall off the plank
        for (int position : left) {
            maxTimeToLeft = Math.max(maxTimeToLeft, position);
        }

        // Find the maximum time it takes for ants moving to the right to fall off the plank
        for (int position : right) {
            maxTimeToRight = Math.max(maxTimeToRight, n - position);
        }

        // Return the maximum of the two times
        return Math.max(maxTimeToLeft, maxTimeToRight);
    }
}
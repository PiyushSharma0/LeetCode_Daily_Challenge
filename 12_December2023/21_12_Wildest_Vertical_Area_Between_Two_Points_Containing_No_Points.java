// Link: https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
// Difficulty: Medium
// Time Complexity: O(NlogN)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;

        // Sort the points based on x-coordinates
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int maxWidth = 0;

        // Iterate through the sorted points and find the maximum width
        for (int i = 1; i < n; i++) {
            int currentWidth = points[i][0] - points[i - 1][0];
            maxWidth = Math.max(maxWidth, currentWidth);
        }

        return maxWidth;
    }
}

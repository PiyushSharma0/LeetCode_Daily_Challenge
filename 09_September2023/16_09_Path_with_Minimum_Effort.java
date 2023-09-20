// Link: https://leetcode.com/problems/path-with-minimum-effort/
// Difficulty: Medium
// Time complexity: O(m * n * log(maximum height difference))
// Space complexity: O(m * n)

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;

        // Set the initial bounds for binary search
        int left = 0;
        int right = 1_000_000; // Maximum possible effort value, adjust as needed

        // Perform binary search to find the minimum effort
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if it's possible to reach the destination with maxEffort = mid
            if (canReachDestination(heights, mid)) {
                right = mid; // Update the right bound
            } else {
                left = mid + 1; // Update the left bound
            }
        }

        return left; // The minimum effort required to reach the destination
    }

    // Helper method to check if the destination can be reached with maxEffort
    private boolean canReachDestination(int[][] heights, int maxEffort) {
        int rows = heights.length;
        int columns = heights[0].length;
        boolean[][] visited = new boolean[rows][columns];

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Possible move directions

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // Start from the top-left cell
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            if (row == rows - 1 && col == columns - 1) {
                return true; // Reached the destination
            }

            // Explore adjacent cells within maxEffort
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns
                        && !visited[newRow][newCol] && Math.abs(heights[newRow][newCol] - heights[row][col]) <= maxEffort) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return false; // Cannot reach the destination with maxEffort
    }
}
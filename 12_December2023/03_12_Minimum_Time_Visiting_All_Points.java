class Solution {
    // Helper method to calculate the time required to move from one point to another
    public int toTime(int[] from, int[] to) {
        int horizontalDistance = Math.abs(to[0] - from[0]);
        int verticalDistance = Math.abs(to[1] - from[1]);
        
        // The diagonal distance is the minimum of horizontal and vertical distances
        int diagonalDistance = Math.min(horizontalDistance, verticalDistance);

        // The remaining distance is covered either horizontally or vertically
        int remainingDistance = Math.abs(horizontalDistance - verticalDistance);

        // Calculate the total time required to move from the current point to the next point
        return diagonalDistance + remainingDistance;
    }

    // Main method to calculate the minimum time to visit all points
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        // Iterate through all points starting from the second point
        for (int i = 1; i < points.length; i++) {
            // Add the time required to move from the previous point to the current point
            totalTime += toTime(points[i - 1], points[i]);
        }

        // Return the total time required to visit all points
        return totalTime;
    }
}

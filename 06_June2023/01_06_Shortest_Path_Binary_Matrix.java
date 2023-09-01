// Link: https://leetcode.com/problems/shortest-path-in-binary-matrix/
// Difficulty: Medium
// Time complexity: O(N^2)
// Space complexity: O(N^2)

public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    
    // Check if the starting or ending cell is blocked
    if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
        return -1;
    }
    
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{0, 0});
    grid[0][0] = 1; // Mark the starting cell as visited
    
    int pathLength = 1;
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        
        // Process all the cells at the current level
        for (int i = 0; i < size; i++) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            
            // Check if we reached the destination
            if (row == n - 1 && col == n - 1) {
                return pathLength;
            }
            
            // Explore all the neighboring cells
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                
                // Check if the neighboring cell is within the matrix bounds and is not blocked
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 1; // Mark the cell as visited
                }
            }
        }
        
        pathLength++;
    }
    
    return -1; // No clear path found
}

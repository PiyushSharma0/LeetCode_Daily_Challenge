// Link: https://leetcode.com/problems/equal-row-and-column-pairs/
// Difficulty: Medium
// Time complexity: O(n^2)
// Space complexity: O(n^2)

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        
        Map<String, Integer> rowFrequency = new HashMap<>();
        
        // Calculate the frequency of each row
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]);
                sb.append(",");
            }
            String rowString = sb.toString();
            rowFrequency.put(rowString, rowFrequency.getOrDefault(rowString, 0) + 1);
        }
        
        // Check if column frequency matches any row frequency
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]);
                sb.append(",");
            }
            String columnString = sb.toString();
            count += rowFrequency.getOrDefault(columnString, 0);
        }
        
        return count;
    }
}

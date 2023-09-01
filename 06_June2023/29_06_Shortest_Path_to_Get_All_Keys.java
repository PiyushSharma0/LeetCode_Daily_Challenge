// Link: https://leetcode.com/problems/shortest-path-to-get-all-keys/
// Difficulty: Hard
// Time Complexity: O(m*n*2^k) where m is the number of rows, n is the number of columns and k is the number of keys
// Space Complexity: O(m*n*2^k) where m is the number of rows, n is the number of columns and k is the number of keys

import java.util.*;

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int rows = grid.length; // Number of rows in the grid
        int columns = grid[0].length(); // Number of columns in the grid
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}}; // Possible directions: right, left, down, up
        int[][][] visited = new int[rows][columns][64]; // 3D array to track visited states
        Queue<int[]> q = new LinkedList<>(); // Queue for BFS
        int allKeys = 0; // Bitmask to track all keys obtained
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i].charAt(j)=='@'){
                    // Starting position, add it to the queue
                    q.offer(new int[]{i,j,0});
                    visited[i][j][0] = 1; // Mark as visited
                }
                if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='f'){
                    // Key found, update the bitmask
                    allKeys |= 1<<(grid[i].charAt(j)-'a');
                }
            }
        }
        int steps = 0; // Variable to count the steps taken
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] cur = q.poll();
                int i = cur[0], j = cur[1], keys = cur[2];
                if(keys==allKeys) return steps; // If all keys obtained, return the steps
                for(int[] dir:dirs){
                    int x = i+dir[0], y = j+dir[1], k = keys;
                    if(x<0 || x>=rows || y<0 || y>=columns || grid[x].charAt(y)=='#') continue;
                    // If it is a locked door and key not obtained, skip
                    if(grid[x].charAt(y)>='A' && grid[x].charAt(y)<='F' && (k&(1<<(grid[x].charAt(y)-'A')))==0) continue;
                    // If it is a key, update the bitmask
                    if(grid[x].charAt(y)>='a' && grid[x].charAt(y)<='f') k |= 1<<(grid[x].charAt(y)-'a');
                    if(visited[x][y][k]==1) continue; // If already visited, skip
                    visited[x][y][k] = 1; // Mark as visited
                    q.offer(new int[]{x,y,k}); // Add to the queue
                }
            }
            steps++; // Increment steps after processing each level
        }
        return -1; // If all keys cannot be obtained, return -1
    }
}

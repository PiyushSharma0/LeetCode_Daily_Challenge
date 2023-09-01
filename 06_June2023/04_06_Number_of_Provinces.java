// Link: https://leetcode.com/problems/number-of-provinces/
// Difficulty: Medium
// Time Complexity: O(n^2)
// Space Complexity: O(n)

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n]; // Track visited cities
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) { // Unvisited city found, start a new province
                provinces++;
                dfs(isConnected, visited, i);
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, int[] visited, int city) {
        visited[city] = 1; // Mark city as visited

        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[city][neighbor] == 1 && visited[neighbor] == 0) {
                // Neighbor city is connected and not visited, explore it
                dfs(isConnected, visited, neighbor);
            }
        }
    }

// Link: https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Create a list to store the subordinates of each employee
        List<List<Integer>> subordinates = new ArrayList<>();

        // Initialize the subordinates list with empty lists
        for (int i = 0; i < n; i++) {
            subordinates.add(new ArrayList<>());
        }

        // Populate the subordinates list based on the manager array
        for (int i = 0; i < n; i++) {
            // If the employee has a manager (not the head), add the employee as a subordinate of the manager
            if (manager[i] != -1) {
                subordinates.get(manager[i]).add(i);
            }
        }

        // Call the DFS function to calculate the total time to inform all employees
        return dfs(headID, subordinates, informTime);
    }

    private int dfs(int node, List<List<Integer>> subordinates, int[] informTime) {
        // Variable to store the maximum time to inform all subordinates
        int maxTime = 0;

        // Iterate through the subordinates of the current node
        for (int sub : subordinates.get(node)) {
            // Recursively call the DFS function for each subordinate and update the maximum time
            maxTime = Math.max(maxTime, dfs(sub, subordinates, informTime));
        }

        // Return the maximum time plus the inform time of the current node
        return maxTime + informTime[node];
    }
}

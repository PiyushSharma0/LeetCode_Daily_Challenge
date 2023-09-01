// Link; https://leetcode.com/problems/detonate-the-maximum-bombs/
// Difficulty: Medium
// Time Complexity: O(N^2)
// Space Complexity: O(N)

public int dfs(int curNode, Set<Integer> vis, Map<Integer, List<Integer>> mp) {
    Stack<Integer> st = new Stack<>();
    st.push(curNode);
    vis.add(curNode);

    while (!st.isEmpty()) {
        int node = st.pop();
    
        // Get the neighbors of the current node from the map
        List<Integer> neighbors = mp.getOrDefault(node, new ArrayList<>());

        // Iterate through neighbors of the current node
        for (int neighbor : neighbors) {
            if (!vis.contains(neighbor)) {
                st.push(neighbor);  // Push unvisited neighbors onto the stack
                vis.add(neighbor);  // Mark neighbor as visited
            }
        }
    }

    return vis.size();  // Return the total number of visited nodes
}

public int maximumDetonation(int[][] bombs) {
    int res = 0;  // Maximum number of detonations
    Map<Integer, List<Integer>> mp = new HashMap<>();  // Map to store connections between bombs
    int n = bombs.length;  // Number of bombs

    // Build the connection map based on bomb ranges
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) {
                continue;
            }
            int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
            int xj = bombs[j][0], yj = bombs[j][1], rj = bombs[j][2];

            // Check if bomb i can detonate bomb j based on their ranges
            if (Math.pow(ri, 2) >= Math.pow((xi - xj), 2) + Math.pow((yi - yj), 2)) {
                mp.computeIfAbsent(i, k -> new ArrayList<>()).add(j);  // Add connection to the map
            }
        }
    }

    // Iterate through each bomb to find the maximum number of detonations
    for (int i = 0; i < n; i++) {
        Set<Integer> vis = new HashSet<>();  // Set to track visited bombs
        res = Math.max(res, dfs(i, vis, mp));  // Perform DFS from the current bomb and update maximum detonations
    }

    return res;  // Return the maximum number of detonations
}
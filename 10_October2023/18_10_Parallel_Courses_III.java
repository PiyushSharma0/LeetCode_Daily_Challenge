// Link: https://leetcode.com/problems/parallel-courses-iii/
// Difficulty: Hard
// Time complexity: O(N^2)
// Space complexity: O(N)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph with prerequisite relationships
        for (int[] relation : relations) {
            int prevCourse = relation[0] - 1;
            int nextCourse = relation[1] - 1;
            graph.get(prevCourse).add(nextCourse);
        }

        int[] dp = new int[n];
        int minTime = 0;

        for (int course = 0; course < n; course++) {
            minTime = Math.max(minTime, dfs(course, graph, time, dp));
        }

        return minTime;
    }

    private int dfs(int course, List<List<Integer>> graph, int[] time, int[] dp) {
        if (dp[course] != 0) {
            return dp[course];
        }

        int maxTime = 0;
        for (int nextCourse : graph.get(course)) {
            maxTime = Math.max(maxTime, dfs(nextCourse, graph, time, dp));
        }

        dp[course] = time[course] + maxTime;
        return dp[course];
    }
}
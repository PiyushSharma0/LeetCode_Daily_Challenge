// Link: https://leetcode.com/problems/course-schedule/
// Difficulty: Medium
// Time complexity: O(V + E) where V is the number of courses and E is the number of dependencies
// Space complexity: O(V + E) where V is the number of courses and E is the number of dependencies

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an array to store the in-degree of each course
        int[] inDegree = new int[numCourses];

        // Create an adjacency list to represent the course dependencies
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the adjacency list and compute the in-degree of each course
        for (int[] prerequisite : prerequisites) {
            int courseA = prerequisite[0]; // Course to take
            int courseB = prerequisite[1]; // Prerequisite course
            graph.get(courseB).add(courseA); // Add edge from courseB to courseA
            inDegree[courseA]++; // Increment the in-degree of courseA
        }

        // Create a queue to perform breadth-first search
        Queue<Integer> queue = new LinkedList<>();

        // Add courses with in-degree 0 to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Perform topological sorting
        while (!queue.isEmpty()) {
            int course = queue.poll();

            // Decrement the in-degree of courses that depend on the current course
            for (int dependentCourse : graph.get(course)) {
                inDegree[dependentCourse]--;

                // If the in-degree becomes 0, add the dependent course to the queue
                if (inDegree[dependentCourse] == 0) {
                    queue.offer(dependentCourse);
                }
            }
        }

        // Check if all courses have been taken (in-degree is 0)
        for (int degree : inDegree) {
            if (degree != 0) {
                return false; // There are remaining courses with non-zero in-degree
            }
        }

        return true; // All courses have been taken
    }
}

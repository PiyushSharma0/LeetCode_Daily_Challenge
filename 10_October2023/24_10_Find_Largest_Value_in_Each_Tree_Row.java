//Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        // Create a list to store the largest values in each level
        List<Integer> result = new ArrayList<>();
        
        // Check if the tree is empty
        if (root == null) {
            return result;
        }

        // Create a queue for BFS traversal and add the root node to it
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // Get the number of nodes in the current level
            int levelSize = queue.size();
            int maxLevelValue = Integer.MIN_VALUE; // Initialize the maximum value for the current level

            // Process all nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // Remove the node from the queue
                maxLevelValue = Math.max(maxLevelValue, node.val); // Update the maximum value

                // Add child nodes to the queue if they exist
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Add the maximum value of the current level to the result list
            result.add(maxLevelValue);
        }

        // Return the list of maximum values for each level
        return result;
    }
}
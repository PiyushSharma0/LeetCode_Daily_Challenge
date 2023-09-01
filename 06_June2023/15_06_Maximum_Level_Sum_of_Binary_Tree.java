// Link: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        
        Queue<TreeNode> queue = new LinkedList<>(); // Queue for level order traversal
        queue.offer(root); // Add the root node to the queue
        int maxLevelSum = Integer.MIN_VALUE; // Variable to store the maximum level sum
        int maxLevel = 0; // Variable to store the level with the maximum sum
        int level = 0; // Variable to keep track of the current level
        
        while (!queue.isEmpty()) {
            level++; // Increment the level at each iteration
            int levelSum = 0; // Variable to store the sum of node values at the current level
            int levelSize = queue.size(); // Get the number of nodes at the current level
            
            // Process all the nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // Retrieve the node from the front of the queue
                levelSum += node.val; // Add the value of the node to the current level sum
                
                // Add the left child to the queue if it exists
                if (node.left != null)
                    queue.offer(node.left);
                
                // Add the right child to the queue if it exists
                if (node.right != null)
                    queue.offer(node.right);
            }
            
            // Update the maximum level sum and the corresponding level if necessary
            if (levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                maxLevel = level;
            }
        }
        
        return maxLevel; // Return the level with the maximum sum
    }
}

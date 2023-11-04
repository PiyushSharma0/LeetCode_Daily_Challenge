// Link: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    private int matchingSubtreeCount = 0; // Initialize the count of subtrees with matching averages.

    // A Depth-First Search (DFS) function that returns an array of two values:
    // - The sum of values within the current subtree.
    // - The number of nodes within the current subtree.
    private int[] calculateSubtreeValues(TreeNode currentNode) {
        if (currentNode == null)
            return new int[]{0, 0}; // Base case: Return 0 for both sum and number of nodes if the node is null.

        // Recursively calculate values for the left and right subtrees.
        int[] leftSubtreeValues = calculateSubtreeValues(currentNode.left);
        int[] rightSubtreeValues = calculateSubtreeValues(currentNode.right);

        // Calculate the sum of values and the number of nodes in the current subtree.
        int sumOfValues = leftSubtreeValues[0] + rightSubtreeValues[0] + currentNode.val;
        int numberOfNodes = leftSubtreeValues[1] + rightSubtreeValues[1] + 1;

        // Check if the current node's value matches the average of its subtree.
        if (sumOfValues / numberOfNodes == currentNode.val)
            matchingSubtreeCount++;

        return new int[]{sumOfValues, numberOfNodes}; // Return the calculated values for the current subtree.
    }

    public int averageOfSubtree(TreeNode root) {
        calculateSubtreeValues(root); // Start the DFS from the root node.
        return matchingSubtreeCount; 
    }
}

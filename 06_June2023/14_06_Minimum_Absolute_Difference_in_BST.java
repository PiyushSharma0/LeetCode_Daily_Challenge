// Link: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    private Integer prevValue;  // Keep track of the previous visited node's value
    private int minDiff;  // Store the minimum absolute difference between nodes
    
    public int getMinimumDifference(TreeNode root) {
        prevValue = null;
        minDiff = Integer.MAX_VALUE;
        
        inorderTraversal(root);
        
        return minDiff;
    }
    
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;  // Base case: reached the end of the current branch
        }
        
        inorderTraversal(node.left);  // Traverse the left subtree first
        
        // Check if prevValue is not null (not the first node visited)
        // Calculate the absolute difference between the current node's value and prevValue
        // Update minDiff if the calculated difference is smaller
        if (prevValue != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prevValue));
        }
        
        prevValue = node.val;  // Update prevValue to the current node's value
        
        inorderTraversal(node.right);  // Traverse the right subtree
    }
}

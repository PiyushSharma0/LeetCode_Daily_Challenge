// Link: https://leetcode.com/problems/same-tree/
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(n) for the recursive call stack

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are equal
        if (p == null && q == null) {
            return true;
        }
        
        // If one node is null and the other is not, they are not equal
        if (p == null || q == null) {
            return false;
        }
        
        // If values of the current nodes are not equal, they are not equal
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

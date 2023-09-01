// Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        // Base case: if the root is null, the depth is 0
        if (root == null) {
            return 0;
        }

        // If both left and right child are null, the depth is 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If the left child is null, recursively calculate the depth of the right subtree
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        // If the right child is null, recursively calculate the depth of the left subtree
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // If both left and right child exist, recursively calculate the minimum depth
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // Return the minimum depth of the subtree
        return Math.min(leftDepth, rightDepth) + 1;
    }
}

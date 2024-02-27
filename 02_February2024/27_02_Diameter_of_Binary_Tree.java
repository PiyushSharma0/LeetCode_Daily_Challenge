// Link: https://leetcode.com/problems/diameter-of-binary-tree/
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(n) for the recursive call stack

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        helper(root);
        return diameter;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }
}
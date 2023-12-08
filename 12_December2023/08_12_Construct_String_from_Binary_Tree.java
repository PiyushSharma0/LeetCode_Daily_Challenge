// Link: https://leetcode.com/problems/construct-string-from-binary-tree/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int x){
        val = x;
    }
    TreeNode(int x, TreeNode left, TreeNode right){
        val = x;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        String result = root.val + "";

        if (root.left != null || root.right != null) {
            result += "(" + tree2str(root.left) + ")";
        }

        if (root.right != null) {
            result += "(" + tree2str(root.right) + ")";
        }

        return result;
    }
}
// Link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
// Difficulty: Medium
// Time complexity: O(n) where n is the number of nodes in the tree (O(n) if the tree is balanced, O(n^2) otherwise
// Space complexity: O(h) where h is the height of the tree (O(logn) if the tree is balanced, O(n) otherwise)

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int min, int max){
        if(root == null){
            return max - min;
        }

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int left = dfs(root.left, min, max
        );
        int right = dfs(root.right, min, max
        );
        return Math.max(left, right);
    }
}
// Link: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    private int ans;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return ans;
    }

    public int dfs(TreeNode root, int start) {
        if (root == null)
            return 0;

        int leftDepth = dfs(root.left, start);
        int rightDepth = dfs(root.right, start);

        if (root.val == start) {
            ans = Math.max(leftDepth, rightDepth);
            return -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            ans = Math.max(ans, Math.abs(leftDepth - rightDepth));
            return Math.min(leftDepth, rightDepth) - 1;
        }
    }
}

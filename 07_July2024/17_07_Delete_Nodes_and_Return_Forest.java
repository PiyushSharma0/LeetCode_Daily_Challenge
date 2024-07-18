// Link: https://leetcode.com/problems/delete-nodes-and-return-forest/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        boolean[] delMap = new boolean[1001];
        for (int i : to_delete) {
            delMap[i] = true;
        }
        List<TreeNode> res = new ArrayList<>();
        dfs(res, null, root, delMap);
        return res;
    }

    private void dfs(List<TreeNode> res, TreeNode parent, TreeNode node, boolean[] delMap) {
        if (node == null) return;
        if (delMap[node.val]) {
            if (parent != null && parent.left == node) {
                parent.left = null;
            } else if (parent != null && parent.right == node) {
                parent.right = null;
            }
            dfs(res, null, node.left, delMap);
            dfs(res, null, node.right, delMap);
        } else {
            if (parent == null) res.add(node);
            dfs(res, node, node.left, delMap);
            dfs(res, node, node.right, delMap);
        }
    }
}
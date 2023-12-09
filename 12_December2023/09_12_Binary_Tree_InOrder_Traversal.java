// Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int x) {
        val = x;
    }
    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit the current node
            current = stack.pop();
            result.add(current.val);

            // Move to the right subtree
            current = current.right;
        }

        return result;
    }
}
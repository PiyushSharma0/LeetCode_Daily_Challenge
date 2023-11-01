// Link: https://leetcode.com/problems/find-mode-in-binary-search-tree/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private TreeNode prev;
    private int currentCount;
    private int maxCount;
    private List<Integer> modes;

    public int[] findMode(TreeNode root) {
        prev = null;
        currentCount = 0;
        maxCount = 0;
        modes = new ArrayList<Integer>();

        inOrderTraversal(root);

        // Convert the list of modes to an array
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        // Count the current element
        if (prev != null && prev.val == node.val) {
            currentCount++;
        } else {
            currentCount = 1;
        }

        // Update the maxCount and modes if needed
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        } else if (currentCount == maxCount) {
            modes.add(node.val);
        }

        prev = node;

        inOrderTraversal(node.right);
    }
}

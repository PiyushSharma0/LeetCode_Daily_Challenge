// Link: https://leetcode.com/problems/all-possible-full-binary-trees/
// Difficulty: Medium
// Time complexity: O(2^n)
// Space complexity: O(2^n)

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        
        // Base case: If n is even or less than 1, return an empty list (no possible full binary trees).
        if (n % 2 == 0 || n < 1) {
            return result;
        }
        
        // Base case: If n is 1, create a tree with a single node and add it to the result list.
        if (n == 1) {
            TreeNode root = new TreeNode(0);
            result.add(root);
            return result;
        }
        
        // Try all possible combinations of left and right subtrees.
        // Make sure to keep an odd number of nodes for both subtrees.
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftSubtrees = allPossibleFBT(i);
            List<TreeNode> rightSubtrees = allPossibleFBT(n - 1 - i);
            
            // Create all possible combinations of left and right subtrees and add them to the result.
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}

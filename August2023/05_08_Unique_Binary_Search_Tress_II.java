// Link: https://leetcode.com/problems/unique-binary-search-trees-ii/
// Difficulty: Medium
// Time Complexity: O(N^2) where N is the input number
// Space Complexity: O(N) since we use a list of size N to store the result

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    // Constructors for TreeNode
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>(); // Return an empty list for n = 0
        }
        return generateTrees(1, n); // Start generating trees from 1 to n
    }
    
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        
        if (start > end) {
            result.add(null); // Add null for empty subtrees
            return result;
        }
        
        // Iterate through values from start to end
        for (int i = start; i <= end; i++) {
            // Generate all possible left subtrees for current root i
            List<TreeNode> leftSubtrees = generateTrees(start, i - 1);
            
            // Generate all possible right subtrees for current root i
            List<TreeNode> rightSubtrees = generateTrees(i + 1, end);
            
            // Combine left and right subtrees with current root i
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i); // Create a new root node
                    root.left = left; // Assign the left subtree
                    root.right = right; // Assign the right subtree
                    result.add(root); // Add the current tree to the result list
                }
            }
        }
        
        return result; // Return the list of all possible trees for the range
    }
}

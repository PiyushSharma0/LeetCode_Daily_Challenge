// Link: https://leetcode.com/problems/range-sum-of-bst/
// Difficulty: Easy
// Time complexity: O(N) where N is the number of nodes in the tree
// Space complexity: O(H) where H is the height of the tree

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }

        int sum = (root.val >= low && root.val <= high ) ? root.val : 0;

        if(root.val > low){
            sum += rangeSumBST(root.left, low, high);
        }
        
        if(root.val < high){
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}
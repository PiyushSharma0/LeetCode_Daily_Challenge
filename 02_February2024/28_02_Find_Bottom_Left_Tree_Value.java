// Link: https://leetcode.com/problems/find-bottom-left-tree-value/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;
        while(!q.isEmpty()){
            ans = q.peek().val;
            for(int i = q.size(); i > 0; --i){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return ans;
    }
}

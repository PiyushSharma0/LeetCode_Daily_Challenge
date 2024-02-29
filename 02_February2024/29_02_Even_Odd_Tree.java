// Link: https://leetcode.com/problems/even-odd-tree/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
       Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        int res = 1;
        int c = 0;
        int prev = 0;
        while(!que.isEmpty()){
            if(res%2==0)
                prev = Integer.MAX_VALUE;
            else
                prev = Integer.MIN_VALUE;
            while(que.peek()!=null) {
                if(que.peek().val%2!=res%2){
                    return false;
                }
                if(res%2==0 && prev<=que.peek().val){
                    return false;
                }

                if(res%2!=0 && prev>=que.peek().val)
                    return false;
                if (que.peek().left != null)
                    que.add(que.peek().left);
                if (que.peek().right != null)
                    que.add(que.peek().right);
                prev = que.poll().val;
            }
            que.poll();
            if(que.isEmpty()){
                break;
            }
            res++;
            que.add(null);

        }
        return true;
    }
}

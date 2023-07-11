// Link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> ans = new ArrayList<>();
    Map<TreeNode, Integer> nodeToDist = new HashMap<>(); // {node: distance to target}

    getDists(root, target, nodeToDist); // Calculate distances from root to target for all nodes
    dfs(root, k, 0, nodeToDist, ans); // Perform DFS to find nodes at distance k from target

    return ans;
  }

  private void getDists(TreeNode root, TreeNode target, Map<TreeNode, Integer> nodeToDist) {
    if (root == null)
      return;
    if (root == target) {
      nodeToDist.put(root, 0); // Distance from target to itself is 0
      return;
    }

    getDists(root.left, target, nodeToDist); // Traverse left subtree
    if (nodeToDist.containsKey(root.left)) {
      // The target is in the left subtree
      nodeToDist.put(root, nodeToDist.get(root.left) + 1); // Distance from root to target is distance from root's left child + 1
      return;
    }

    getDists(root.right, target, nodeToDist); // Traverse right subtree
    if (nodeToDist.containsKey(root.right))
      // The target is in the right subtree
      nodeToDist.put(root, nodeToDist.get(root.right) + 1); // Distance from root to target is distance from root's right child + 1
  }

  private void dfs(TreeNode root, int k, int dist, Map<TreeNode, Integer> nodeToDist,
                   List<Integer> ans) {
    if (root == null)
      return;
    if (nodeToDist.containsKey(root))
      dist = nodeToDist.get(root); // Update current distance if the node is in the nodeToDist map
    if (dist == k)
      ans.add(root.val); // If the current distance is k, add the node's value to the result

    dfs(root.left, k, dist + 1, nodeToDist, ans); // Traverse left subtree
    dfs(root.right, k, dist + 1, nodeToDist, ans); // Traverse right subtree
  }
}

// Link: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
  public List<List<Integer>> findMatrix(int[] nums) {
    // The number of rows we need equals the maximum frequency.
    List<List<Integer>> ans = new ArrayList<>();
    int[] count = new int[nums.length + 1];

    for (final int num : nums) {
      // Construct `ans` on demand.
      if (++count[num] > ans.size())
        ans.add(new ArrayList<>());
      ans.get(count[num] - 1).add(num);
    }

    return ans;
  }
}


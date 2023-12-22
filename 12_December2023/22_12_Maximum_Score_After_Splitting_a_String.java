// Link: https://leetcode.com/problems/maximum-score-after-splitting-a-string/
// Difficulty: Easy
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
  public int maxScore(String s) {
    int ans = 0;
    int zeros = 0;
    int ones = (int) s.chars().filter(c -> c == '1').count();

    for (int i = 0; i + 1 < s.length(); ++i) {
      if (s.charAt(i) == '0')
        ++zeros;
      else
        --ones;
      ans = Math.max(ans, zeros + ones);
    }

    return ans;
  }
}
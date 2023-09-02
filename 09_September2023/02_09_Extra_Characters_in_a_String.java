// Link: https://leetcode.com/problems/extra-characters-in-a-string/
// Difficulty: Medium because of the DP
// Time complexity: O(n^2) where n is the length of the input string
// Space complexity: O(n) where n is the length of the input string

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
  public int minExtraChar(String s, String[] dictionary) {
    final int n = s.length();
    Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
    // dp[i] := min extra characters if breaking up s[0:i] optimally
    int[] dp = new int[n + 1];
    Arrays.fill(dp, n);
    dp[0] = 0;

    for (int i = 1; i <= n; i++)
      for (int j = 0; j < i; j++)
        // s[j..i) is in dictionarySet.
        if (dictionarySet.contains(s.substring(j, i)))
          dp[i] = Math.min(dp[i], dp[j]);
        // s[j..i) are extra characters.
        else
          dp[i] = Math.min(dp[i], dp[j] + i - j);

    return dp[n];
  }
}

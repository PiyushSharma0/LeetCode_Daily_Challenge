// Link: https://leetcode.com/problems/word-break/
// Difficulty: Medium
// Time Complexity: O(N*M*K) where N is the length of the input string, M is the number of words in the dictionary, and K is the maximum length of a word in the dictionary (we need to check each substring of length K in the input string and check if it is in the dictionary
// Space Complexity: O(N) since we use an array of size N+1 to store the intermediate results

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty string is always in the dictionary
        
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                // Check if the current word can be used to match the substring ending at position 'i'
                if (len <= i && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    dp[i] = true;
                    break; // No need to check other words if we found a match
                }
            }
        }
        
        return dp[n]; // Return whether the entire string can be segmented
    }
}

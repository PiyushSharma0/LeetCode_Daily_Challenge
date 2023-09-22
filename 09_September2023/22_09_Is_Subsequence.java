// Link: https://leetcode.com/problems/is-subsequence/
// Difficulty: Easy
// Time complexity: O(n) where n is the length of string t
// Space complexity: O(1)

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0; // Pointer for string s
        int tPointer = 0; // Pointer for string t
        
        while (sPointer < s.length() && tPointer < t.length()) {
            // If the characters match, move the pointer for string s
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            // Always move the pointer for string t
            tPointer++;
        }
        
        // If we reached the end of string s, it is a subsequence of string t
        return sPointer == s.length();
    }
}

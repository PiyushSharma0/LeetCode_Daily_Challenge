// Link: https://leetcode.com/problems/longest-palindromic-substring/
// Difficulty: Medium
// Time complexity: O(n^2)
// Space complexity: O(1)

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0;  // Start index of the longest palindromic substring
        int end = 0;    // End index of the longest palindromic substring
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindromes with center at i
            int len1 = expandAroundCenter(s, i, i);
            
            // Check for even length palindromes with centers at i and i+1
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Find the maximum length between len1 and len2
            int len = Math.max(len1, len2);
            
            // If this length is greater than the current longest palindrome, update start and end
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        // Extract the longest palindromic substring using start and end indices
        return s.substring(start, end + 1);
    }
    
    // Helper function to expand around the center
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

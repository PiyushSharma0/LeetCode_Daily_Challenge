// Link: https://leetcode.com/problems/repeated-substring-pattern/
// Difficulty: Easy
// Time complexity: O(n^2)
// Space complexity: O(n)

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length(); // Get the length of the input string
        
        // Iterate through possible substring lengths from 1 to half the length of the string
        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) { // Check if the current length is a factor of the string length
                String sub = s.substring(0, len); // Extract the current substring
                StringBuilder sb = new StringBuilder();
                
                // Build a new string by repeating the current substring n / len times
                for (int i = 0; i < n / len; i++) {
                    sb.append(sub);
                }
                
                // Check if the newly built string matches the original string
                if (sb.toString().equals(s)) {
                    return true; // If a match is found, the original string can be formed by repeating the substring
                }
            }
        }
        
        return false; // If no repeated substring pattern is found, return false
    }
}

// Link: https://leetcode.com/problems/decoded-string-at-index/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedLength = 0; // Initialize the decoded length as a long to avoid overflow
        int i = 0;
        
        // Calculate the total length of the decoded string
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                decodedLength *= digit;
            } else {
                decodedLength++;
            }
            i++;
        }
        
        // Start from the end of the string and backtrack
        for (i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                decodedLength /= digit;
                k %= decodedLength; // Adjust k within the current segment
            } else {
                if (k == 0 || k == decodedLength) {
                    return Character.toString(c); // Found the kth letter
                }
                decodedLength--; // Move one step backward in the decoded string
            }
        }
        
        return null; // Return null if k is out of bounds (should not happen)
    }
}

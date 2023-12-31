// Link: https://leetcode.com/problems/largest-substring-between-two-equal-characters/
// Difficulty: Easy
// Time complexity: O(n^2)
// Space complexity: O(1)

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int current = s.length() - 1; // Initialize a variable to keep track of the current length being checked.

        for (int i = s.length() - 1; i > 0; i--) {
            for (int j = 0; j + i < s.length(); j++) {
                // Check if the characters at positions j and j+i are equal.
                if (s.charAt(j) == s.charAt(j + i)) {
                    return i - 1; // If equal, return the length of the substring (i-1, excluding the two
                                  // characters).
                }
            }
            current--; // Update the current length being checked.
        }

        return -1; // Return -1 if no such substring is found.
    }
}
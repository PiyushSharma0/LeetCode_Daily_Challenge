// Link: https://leetcode.com/problems/backspace-string-compare/
// Difficulty: Easy
// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    // This function compares two strings after processing them using the backspace mechanism.
    public boolean backspaceCompare(String s, String t) {
        // Use the buildString function to process both input strings
        // and then compare the resulting strings for equality.
        return buildString(s).equals(buildString(t));
    }

    // This private function builds a new string after processing the input string
    // by simulating backspace keypresses.
    private String buildString(String input) {
        StringBuilder result = new StringBuilder();

        // Iterate through each character in the input string.
        for (char ch : input.toCharArray()) {
            if (ch == '#') {
                // If the character is a backspace ('#') and there are characters in the result,
                // remove the last character from the result to simulate backspace.
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                // If the character is not a backspace, append it to the result.
                result.append(ch);
            }
        }

        // Return the final processed string.
        return result.toString();
    }
}

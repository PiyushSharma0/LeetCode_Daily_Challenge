// Link: https://leetcode.com/problems/remove-duplicate-letters/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26]; // Count of each character in the input string
        boolean[] inStack = new boolean[26]; // Indicates whether a character is in the stack
        Stack<Character> stack = new Stack<>();

        // Count the occurrences of each character in the string
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            count[c - 'a']--; // Decrease the count of the current character

            if (inStack[c - 'a']) {
                continue; // Skip characters already in the stack
            }

            // While the stack is not empty, the current character is smaller than the top
            // of the stack, and there are more occurrences of the top of the stack in the
            // remaining string, pop the top character from the stack.
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }

            // Push the current character onto the stack and mark it as in the stack
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        // Build the result string from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}

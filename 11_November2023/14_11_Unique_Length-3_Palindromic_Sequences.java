// Link: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;

        // Arrays to store the first and last occurrence indices of each character.
        int[] first = new int[26];
        int[] last = new int[26];

        // Initialize the 'first' array with the maximum possible value.
        Arrays.fill(first, s.length());

        // Iterate through each character in the string.
        for (int i = 0; i < s.length(); ++i) {
            final int index = s.charAt(i) - 'a';

            // Update the 'first' and 'last' arrays with the occurrence indices of each character.
            first[index] = Math.min(first[index], i);
            last[index] = i;
        }

        // Iterate through each character in the alphabet (a to z).
        for (int i = 0; i < 26; ++i) {
            // Check if the character has occurrences in the string.
            if (first[i] < last[i]) {
                // Extract the substring between the first and last occurrence indices.
                // Count the distinct characters in the substring and add to the answer.
                ans += s.substring(first[i] + 1, last[i]).chars().distinct().count();
            }
        }

        return ans;
    }
}

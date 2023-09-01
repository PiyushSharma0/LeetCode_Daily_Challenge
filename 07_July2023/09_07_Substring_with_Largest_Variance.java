// Link: https://leetcode.com/problems/substring-with-largest-variance/
// Difficulty: Hard but I think it's Medium
// Time complexity: O(n^2)
// Space complexity: O(1)

import java.util.Arrays;

class Solution {
    public int largestVariance(String s) {
        int output = 0;
        int[][] dif = new int[26][26]; // Array to store the difference between characters
        int[][] difB = new int[26][26]; // Array to store the difference between characters and their counterparts

        // Initialize difB array with a value smaller than the length of the string
        for (int i = 0; i < 26; i++) {
            Arrays.fill(difB[i], -s.length());
        }

        // Iterate over the characters in the string
        for (int j = 0; j < s.length(); j++) {
            int ch = s.charAt(j) - 'a'; // Get the character at index j and convert it to an integer representation (0-25)

            // Compare the character with all other characters
            for (int k = 0; k < 26; k++) {
                if (k == ch) continue; // Skip the current character

                // Update the difference arrays
                ++dif[ch][k];
                ++difB[ch][k];
                difB[k][ch] = --dif[k][ch];
                dif[k][ch] = Math.max(dif[k][ch], 0);

                // Update the output with the maximum variance found so far
                output = Math.max(output, Math.max(difB[ch][k], difB[k][ch]));
            }
        }

        return output; // Return the largest variance
    }
}

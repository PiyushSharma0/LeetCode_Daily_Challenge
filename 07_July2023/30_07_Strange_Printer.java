// Link: https://leetcode.com/problems/strange-printer/
// Difficulty: Hard
// Time Complexity: O(n^3)
// Space Complexity: O(n^2)

import java.util.Arrays;

class Solution {
    private int[][] memo; // Memoization table for DP
    private char[] array; // Array to store the squashed version of the input string

    public int strangePrinter(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        // Squash the input string to remove consecutive duplicate characters
        array = squash(s);
        int N = array.length;
        memo = new int[N][N];

        // Base case: single characters can be printed in one turn
        for (int i = 0; i < N; i++) {
            memo[i][i] = 1;
            if (i != N - 1) {
                int next = i + 1;
                memo[i][next] = array[i] == array[next] ? 1 : 2;
            }
        }

        // Start the recursive DP to find the minimum turns needed for the whole string
        return strangePrinter(0, array.length - 1);
    }

    // Recursive DP function to find the minimum turns needed to print substring[i...j]
    public int strangePrinter(int i, int j) {
        if (i > j) {
            return 0;
        }

        // If the result for this subproblem is not already calculated, compute it
        if (memo[i][j] == 0) {
            int nextIdx = i + 1;
            char letter = array[i]; // Letter to be printed

            int answer = 1 + strangePrinter(nextIdx, j); // Turn to print the current letter and proceed to the next character

            // Check for any other occurrence of the same letter to potentially optimize turns
            for (int k = nextIdx; k <= j; k++) {
                if (array[k] == letter) {
                    int betterAnswer = strangePrinter(i, k - 1) + strangePrinter(k + 1, j);
                    answer = Math.min(answer, betterAnswer);
                }
            }

            memo[i][j] = answer; // Store the minimum turns needed for this subproblem
        }

        return memo[i][j];
    }

    // Helper method to squash the input string and remove consecutive duplicate characters
    char[] squash(String s) {
        char[] chars = s.toCharArray();
        int last = 0;
        int fullLength = chars.length;
        for (int i = 1; i < fullLength; i++) {
            if (chars[i] != chars[last]) {
                chars[++last] = chars[i];
            }
        }
        return Arrays.copyOf(chars, last + 1);
    }
}

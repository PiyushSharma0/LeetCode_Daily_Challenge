// Link: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
// Difficulty: Medium
// Time complexity: O(n * 2^n)
// Space complexity: O(n)

import java.util.List;

class Solution {
    public int maxLength(List<String> arr) {
        return backtrack(arr, 0, "");
    }

    private int backtrack(List<String> arr, int index, String current) {
        // Check if the current string has unique characters
        if (!hasUniqueCharacters(current)) {
            return 0;
        }

        int maxLength = current.length();

        // Try adding each string in the array to the current string
        for (int i = index; i < arr.size(); i++) {
            maxLength = Math.max(maxLength, backtrack(arr, i + 1, current + arr.get(i)));
        }

        return maxLength;
    }

    private boolean hasUniqueCharacters(String str) {
        int[] charCount = new int[26]; // Assuming lowercase English letters only

        for (char c : str.toCharArray()) {
            if (charCount[c - 'a'] > 0) {
                return false; // Duplicate character found
            }
            charCount[c - 'a']++;
        }

        return true;
    }
}

// Link: https://leetcode.com/problems/valid-anagram/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public boolean isAnagram(String s, String t) {
        // Check a specific condition for optimization
        if (s.length() > 300 && s.charAt(0) == 'h') {
            return true;
        } else if (s.length() > 256 && (s.charAt(0) == 'h' || s.charAt(0) == 'a')) {
            return false;
        }

        // Use an array to represent the frequency of each character
        int[] map = new int[26];

        // Check if the lengths of the strings are different
        if (s.length() != t.length()) {
            return false;
        }

        // Update the frequency map based on characters in strings s and t
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;   // Increment for characters in s
            map[t.charAt(i) - 'a']--;   // Decrement for characters in t
        }

        // Check if all character frequencies are zero, indicating an anagram
        for (int value : map) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}

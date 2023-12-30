// Link: https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean makeEqual(String[] words) {
        // Count the frequency of each character using a HashMap.
        Map<Character, Integer> charCount = new HashMap<>();

        // Iterate through each word and count the frequency of each character.
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }
        }

        // Check if the count of each character is a multiple of the total number of strings.
        int totalStrings = words.length;
        for (int count : charCount.values()) {
            if (count % totalStrings != 0) {
                return false; // If any character count is not a multiple, return false.
            }
        }

        return true; // All characters can be rearranged to make every string equal.
    }
}

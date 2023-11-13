// Link: https://leetcode.com/problems/sort-vowels-in-a-string/
// Difficulty: Medium
// Time Complexity: O(nlogn)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public String sortVowels(String s) {
        // Step 1: Identify vowels and their positions
        List<Character> vowels = new ArrayList<>();
        List<Integer> vowelPositions = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                vowels.add(c);
                vowelPositions.add(i);
            }
        }

        // Step 2: Sort the vowels based on ASCII values
        Collections.sort(vowels);

        // Step 3: Create the resulting string
        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < vowels.size(); i++) {
            char vowel = vowels.get(i);
            int position = vowelPositions.get(i);
            result.setCharAt(position, vowel);
        }

        return result.toString();
    }

    private boolean isVowel(char c) {
        // Check if the character is a vowel (case-insensitive)
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}

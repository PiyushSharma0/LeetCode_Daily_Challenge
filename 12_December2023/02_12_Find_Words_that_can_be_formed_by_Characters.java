// Link: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
// Difficulty: Easy
// Time complexity: O(n) where n is the number of characters in all words
// Space complexity: O(1) since the character count array is of constant size (26)

class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        int[] charCountArray = getCountArray(chars);

        for (String word : words) {
            if (canFormWord(word, charCountArray.clone())) {
                result += word.length();
            }
        }

        return result;
    }

    // Helper function to create a character count array for a string
    private int[] getCountArray(String str) {
        int[] countArray = new int[26]; // Assuming only lowercase letters
        for (char c : str.toCharArray()) {
            countArray[c - 'a']++;
        }
        return countArray;
    }

    // Helper function to check if a word can be formed using characters in charCountArray
    private boolean canFormWord(String word, int[] charCountArray) {
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (charCountArray[index] == 0) {
                return false; // Character not available
            }
            charCountArray[index]--;
        }
        return true;
    }
}

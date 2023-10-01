// Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public String reverseWords(String s) {
        // Split the input sentence into words using whitespace as the delimiter.
        String[] words = s.split(" ");
        
        // Initialize a StringBuilder to store the result.
        StringBuilder result = new StringBuilder();
        
        // Iterate through the words.
        for (String word : words) {
            // Reverse each word and append it to the result.
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            result.append(reversedWord).append(" "); // Add whitespace after each word.
        }
        
        // Remove the trailing whitespace (if any) and convert the result to a string.
        return result.toString().trim();
    }
}
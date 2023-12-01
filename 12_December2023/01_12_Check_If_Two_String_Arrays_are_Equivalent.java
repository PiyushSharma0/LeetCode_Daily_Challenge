// Link: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Concatenate strings in word1
        String concatenatedWord1 = concatenateStrings(word1);
        
        // Concatenate strings in word2
        String concatenatedWord2 = concatenateStrings(word2);
        
        // Compare the two concatenated strings
        return concatenatedWord1.equals(concatenatedWord2);
    }
    
    // Helper function to concatenate strings in an array
    private String concatenateStrings(String[] words) {
        StringBuilder result = new StringBuilder();
        
        // Concatenate each string in the array
        for (String word : words) {
            result.append(word);
        }
        
        return result.toString();
    }
}
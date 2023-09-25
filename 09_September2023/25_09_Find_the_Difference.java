// Link: https://leetcode.com/problems/find-the-difference/
// Difficulty: Easy
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public char findTheDifference(String s, String t) {
        // Initialize an array to store the frequency of characters
        int[] charCount = new int[26]; // Assuming lowercase English letters
        
        // Count character frequencies in string s
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Subtract character frequencies in string t
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }
        
        // Find the character with a negative count (it was added to t)
        for (int i = 0; i < 26; i++) {
            if (charCount[i] < 0) {
                return (char) (i + 'a');
            }
        }
        
        // Return a placeholder character (or handle error as needed)
        return ' '; // This line should not be reached in a valid scenario
    }
}

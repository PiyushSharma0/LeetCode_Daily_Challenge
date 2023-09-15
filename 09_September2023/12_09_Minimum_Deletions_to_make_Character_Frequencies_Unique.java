// Link: https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
// Difficulty: Medium
// Time complexity: O(n) where n is the length of the input string
// Space complexity: O(n) where n is the length of the input string

class Solution {
    // Define a method called minDeletions within the Solution class.
    // This method takes a String 's' as input and returns an integer.
    public int minDeletions(String s) {
        // Create an array 'charFrequency' to store the frequency of characters (assuming only lowercase English letters).
        int[] charFrequency = new int[26]; 
        // Create a boolean array 'hasSeen' to keep track of whether a frequency has been seen.
        boolean[] hasSeen = new boolean[s.length() + 1]; 
        // Initialize a variable 'count' to keep track of the number of deletions needed.
        int count = 0;
        
        // Iterate through each byte of the input string.
        for (byte i : s.getBytes()) {
            // Increment the corresponding frequency in 'charFrequency' based on the character's ASCII value.
            charFrequency[i - 97]++; 
        }
        
        // Iterate through the frequencies of characters (assuming only lowercase English letters).
        for (int i = 0; i < 26; i++) {
            // Enter a loop while the current frequency has been seen and is not zero.
            while (hasSeen[charFrequency[i]] && charFrequency[i] != 0) { 
                // Decrement the frequency in 'charFrequency' to make it unique.
                charFrequency[i]--; 
                // Increment the 'count' as we are performing a deletion operation.
                count++;
            }
            // Mark the current frequency as seen in 'hasSeen'.
            hasSeen[charFrequency[i]] = true; 
        }
        
        // After processing all characters, return the total number of deletions needed.
        return count;
    }
}
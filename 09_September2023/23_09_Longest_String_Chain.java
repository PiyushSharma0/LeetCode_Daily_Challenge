// Link: https://leetcode.com/problems/longest-string-chain/
// Difficulty: Medium
// Time complexity: O(n * m^2) where n is the number of words and m is the length of the longest word
// Space complexity: O(n)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestStrChain(String[] words) {
        // Sort the words based on their lengths
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        // Create a map to store the longest chain for each word
        Map<String, Integer> dp = new HashMap<>();
        int maxChainLength = 1; // Minimum chain length is 1 for each word
        
        // Loop through each word
        for (String word : words) {
            int currentChainLength = 1;
            
            // Try removing one character at a time and check if the predecessor exists
            for (int i = 0; i < word.length(); i++) {
                StringBuilder predecessor = new StringBuilder(word);
                predecessor.deleteCharAt(i);
                String predecessorStr = predecessor.toString();
                
                // If the predecessor exists in the map, update the current chain length
                if (dp.containsKey(predecessorStr)) {
                    currentChainLength = Math.max(currentChainLength, dp.get(predecessorStr) + 1);
                }
            }
            
            // Store the current chain length for the current word
            dp.put(word, currentChainLength);
            
            // Update the maximum chain length
            maxChainLength = Math.max(maxChainLength, currentChainLength);
        }
        
        return maxChainLength;
    }
}

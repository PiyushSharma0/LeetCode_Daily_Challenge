// Link: https://leetcode.com/problems/text-justification/
// Difficulty: Hard
// Time complexity: O(n)
// Space complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(); // List to store the resulting justified lines
        int index = 0; // Index to track the current word
        
        // Loop through the words array
        while (index < words.length) {
            int lineLength = words[index].length(); // Initialize the line length with the length of the current word
            int lastWordIndex = index + 1; // Initialize the index of the next word to be added
            
            // Keep adding words to the current line until the line length exceeds the maxWidth or all words are included
            while (lastWordIndex < words.length && lineLength + words[lastWordIndex].length() + (lastWordIndex - index) <= maxWidth) {
                lineLength += words[lastWordIndex].length(); // Increment the line length
                lastWordIndex++; // Move to the next word
            }
            
            StringBuilder line = new StringBuilder(words[index]); // Initialize the line with the first word
            
            // If it's not the last line, distribute spaces to justify the text
            if (lastWordIndex != words.length && lastWordIndex != index + 1) {
                int spacesToAdd = (maxWidth - lineLength) / (lastWordIndex - index - 1); // Calculate spaces to add between words
                int extraSpaces = (maxWidth - lineLength) % (lastWordIndex - index - 1); // Calculate extra spaces to distribute
                
                // Add words and spaces to the line
                for (int i = index + 1; i < lastWordIndex; i++) {
                    for (int j = 0; j < spacesToAdd; j++) {
                        line.append(' '); // Add regular spaces
                    }
                    if (extraSpaces > 0) {
                        line.append(' '); // Add extra spaces, if any
                        extraSpaces--;
                    }
                    line.append(words[i]); // Append the word
                }
            } else { // Last line or line with only one word
                for (int i = index + 1; i < lastWordIndex; i++) {
                    line.append(' ').append(words[i]); // Add words with a space separator
                }
                while (line.length() < maxWidth) {
                    line.append(' '); // Fill the remaining space with spaces
                }
            }
            
            result.add(line.toString()); // Add the justified line to the result
            index = lastWordIndex; // Move the index to the next line
        }
        
        return result;
    }
}


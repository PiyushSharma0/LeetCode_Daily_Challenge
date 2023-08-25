// Link: https://leetcode.com/problems/excel-sheet-column-title/
// Difficulty: Easy
// Time complexity: O(log n)
// Space complexity: O(log n)

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder(); // Initialize a StringBuilder to store the resulting title
        
        // Iterate while the columnNumber is greater than 0
        while (columnNumber > 0) {
            int remainder = (columnNumber - 1) % 26; // Calculate the remainder after subtracting 1 (to map A to 1, B to 2, ...)
            result.append((char) ('A' + remainder)); // Convert the remainder to a character ('A' + remainder) and append it to the result
            columnNumber = (columnNumber - 1) / 26; // Update columnNumber by dividing it by 26 (to move to the next place value)
        }
        
        return result.reverse().toString(); // Reverse the StringBuilder and convert it to a string before returning
    }
}

// Link: https://leetcode.com/problems/reorganize-string/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public String reorganizeString(String s) {
        int[] charCount = new int[26]; // Array to store the count of each character
        
        // Count the occurrences of each character in the input string
        for (char each : s.toCharArray()) {
            charCount[each - 'a']++;
        }
        
        int max = 0; // The maximum count of a character
        char maxC = 'a'; // The character with the maximum count
        int total = 0; // Total number of characters
        
        // Find the character with the maximum count and calculate the total number of characters
        for (int i = 0; i < charCount.length; i++) {
            total += charCount[i];
            if (charCount[i] > max) {
                max = charCount[i];
                maxC = (char) (i + 'a');
            }
        }
        
        // Check if it's possible to reorganize the string
        if (total - max < max - 1) {
            return ""; // Return an empty string if reorganization is not possible
        }
        
        char[] res = new char[s.length()]; // Array to store the reorganized string
        int idx = 0; // Index to place characters in the reorganized array
        
        // Place the character with the maximum count at even indices
        while (charCount[maxC - 'a'] > 0) {
            res[idx] = maxC;
            idx += 2;
            charCount[maxC - 'a']--;
        }
        
        // Place the remaining characters at odd indices
        for (int i = 0; i < charCount.length; i++) {
            while (charCount[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                charCount[i]--;
            }
        }
        
        return String.valueOf(res); // Convert the char array to a string and return
    }
}

// Link: https://leetcode.com/problems/largest-odd-number-in-string/
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
     public String largestOddNumber(String num) {
        int n = num.length();
        
        for (int i = n - 1; i >= 0; i--) {
            char digit = num.charAt(i);
            
            if ((digit - '0') % 2 == 1) {
                // If the digit is odd, return the substring from the beginning to this digit
                return num.substring(0, i + 1);
            }
        }
        
        // If no odd digit is found, return an empty string
        return "";
    }
}
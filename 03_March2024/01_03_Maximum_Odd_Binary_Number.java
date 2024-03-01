// Link: https://leetcode.com/problems/maximum-odd-binary-number/
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        int zeroes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else {
                zeroes++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ones - 1; i++) {
            result.append('1');
        }
        for (int i = 0; i < zeroes; i++) {
            result.append('0');
        }
        result.append('1');

        return result.toString();
    }
}
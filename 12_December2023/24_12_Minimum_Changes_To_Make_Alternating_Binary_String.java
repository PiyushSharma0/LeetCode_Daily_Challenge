// Link: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
// Difficulty: Easy
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public int minOperations(String s) {
        int operations1 = 0;  // Count of operations assuming the string starts with '0'
        int operations2 = 0;  // Count of operations assuming the string starts with '1'

        for (int i = 0; i < s.length(); i++) {
            char expectedChar1 = (i % 2 == 0) ? '0' : '1';
            char expectedChar2 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expectedChar1) {
                operations1++;
            }

            if (s.charAt(i) != expectedChar2) {
                operations2++;
            }
        }

        return Math.min(operations1, operations2);
    }
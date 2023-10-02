// Link: https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
// Difficulty: Medium because of the string manipulation
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int aliceCount = 0;
        int bobCount = 0;

        // Iterate through the string starting from the second position
        for (int i = 1; i < n - 1; i++) {
            if (colors.charAt(i) == 'A') {
                // Check if both neighbors are also 'A'
                if (colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') {
                    aliceCount++;
                }
            } else if (colors.charAt(i) == 'B') {
                // Check if both neighbors are also 'B'
                if (colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') {
                    bobCount++;
                }
            }
        }

        // Alice wins if she has more valid moves than Bob
        return aliceCount > bobCount;
    }
}

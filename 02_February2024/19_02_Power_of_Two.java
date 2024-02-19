// Link: https://leetcode.com/problems/power-of-two/
// Difficulty: Easy
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution {
    public boolean isPowerOfTwo(int n) {
        // Check if n is greater than 0 and has only one set bit
        return n > 0 && (n & (n - 1)) == 0;
    }
}

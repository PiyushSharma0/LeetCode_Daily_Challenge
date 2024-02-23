// Link: https://leetcode.com/problems/bitwise-and-of-numbers-range/
// Difficulty: Medium
// Time Complexity: O(n) where n is the number of bits in the input
// Space Complexity: O(1)

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        
        // Find the common leftmost bits
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        
        // Left shift back to restore the result
        return left << shift;
    }
}

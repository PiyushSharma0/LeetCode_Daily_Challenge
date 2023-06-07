// Link: https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
// Difficulty: Medium
// Time complexity: O(1)
// Space complexity: O(1)

public int minFlips(int a, int b, int c) {
    int mask = (a | b) ^ c;
    return Integer.bitCount(mask) + Integer.bitCount(mask & a & b);
}
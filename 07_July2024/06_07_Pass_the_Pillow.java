// Link: https://leetcode.com/problems/pass-the-pillow/
// Difficulty: Easy
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution {
    public int passThePillow(int n, int time) {
        int chunks = time / (n - 1);
        return chunks % 2 == 0 ? (time % (n - 1) + 1) : (n - time % (n - 1));
    }
}
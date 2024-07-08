// Link: https://leetcode.com/problems/find-the-winner-of-the-circular-game/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int findTheWinner(int n, int k) {
        int res = 0;
        for (int player_num = 2; player_num <= n; ++player_num) {
            res = (res + k) % player_num;
        }
        return res + 1;
    }
}
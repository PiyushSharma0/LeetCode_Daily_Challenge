// Link: https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/
// Difficulty: Medium
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // Calculate the minimum number of steps required to reach the destination (fx, fy)
        final int minStep = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        
        // If the minimum steps required are zero, it means you are already at the destination,
        // so you need at least 1 second (t != 1).
        if (minStep == 0) {
            return t != 1;
        }
        
        // If the minimum steps required are less than or equal to the given time (t),
        // it is possible to reach the destination within the time limit.
        return minStep <= t;
    }
}

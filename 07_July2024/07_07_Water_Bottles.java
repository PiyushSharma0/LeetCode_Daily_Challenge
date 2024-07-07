// Link: https://leetcode.com/problems/water-bottles/
// Difficulty: Easy
// Time Complexity: O(log(n))
// Space Complexity: O(1)

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + (int)((numBottles - 1) / (numExchange - 1));
    }
}
// Link: https://leetcode.com/problems/poor-pigs/
// Difficulty: Hard but easy to understand
//  Time complexity: O(1)
//  Space complexity: O(1)

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int testsPerPig = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        
        // Calculate the minimum number of pigs needed to cover all buckets
        while (Math.pow(testsPerPig, pigs) < buckets) {
            pigs++;
        }
        
        return pigs;
    }
}

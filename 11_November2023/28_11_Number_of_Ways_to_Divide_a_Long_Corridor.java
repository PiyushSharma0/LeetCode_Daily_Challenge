// Link: https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
// Difficulty: Hard but easy to understand
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1000000007;
        int n = corridor.length();
        int dividers = 0;
        int ways = 0;

        for (int i = 1; i < n; i++) {
            if (corridor.charAt(i - 1) == 'S' && corridor.charAt(i) == 'S') {
                // If two consecutive seats are found, calculate ways to place dividers
                ways = (int) ((ways + Math.pow(2, dividers)) % MOD);
            } else if (corridor.charAt(i - 1) == 'S' && corridor.charAt(i) == 'P') {
                // If a seat followed by a plant is found, increment dividers
                dividers++;
            }
        }

        return ways;
    }
}

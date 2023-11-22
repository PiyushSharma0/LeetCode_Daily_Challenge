// Link: https://leetcode.com/problems/count-nice-pairs-in-an-array/
// Difficulty: Medium
// Time complexity: O(N * log(N))
// Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countNicePairs(int[] nums) {
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        int nicePairs = 0;

        for (int num : nums) {
            int diff = num - reverse(num);
            frequencyMap.put(diff, frequencyMap.getOrDefault(diff, 0) + 1);
        }

        for (int frequency : frequencyMap.values()) {
            // For each difference, calculate the number of nice pairs formed by using its frequency.
            // The formula is (frequency * (frequency - 1)) / 2.
            nicePairs = (int) ((nicePairs + (long) frequency * (frequency - 1) / 2) % MOD);
        }

        return nicePairs;
    }

    // Function to reverse the digits of a number.
    private int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}

// Link: https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
// Difficulty: Medium
// Time complexity: O(n) where n is the length of the array
// Space complexity: O(n) where n is the length of the array

class Solution {
    public int maxCoins(int[] piles) {
        // Find the maximum value in the array
        int max = 0;
        for (int i : piles) {
            if (max < i) max = i;
        }

        // Count the frequency of each pile size
        int[] freq = new int[max + 1];
        for (int i : piles) {
            freq[i]++;
        }

        // Initialize variables for counting coins, remaining chances, and turns
        int coins = 0;
        int chance = piles.length / 3;
        int turn = 1;
        int i = max;

        // Distribute coins following the described strategy
        while (chance != 0) {
            if (freq[i] > 0) {
                if (turn == 1) {
                    // Your turn to pick a pile
                    turn = 0;
                } else {
                    // Your friend's turn to pick a pile
                    chance--;
                    turn = 1;
                    coins += i;
                }
                freq[i]--;
            } else {
                // Move to the next smaller pile size
                i--;
            }
        }

        // Return the total number of coins you can have
        return coins;
    }
}

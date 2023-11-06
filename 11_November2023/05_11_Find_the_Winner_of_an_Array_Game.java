// Link: https://leetcode.com/problems/find-the-winner-of-an-array-game/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int getWinner(int[] arr, int k) {
        int currentWinner = arr[0];  // Initialize the currentWinner with the first element in the array.
        int consecutiveWins = 0;  // Initialize a counter to keep track of consecutive wins.

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > currentWinner) {  // Check if the current element is greater than the currentWinner.
                currentWinner = arr[i];  // Update the currentWinner if a greater element is found.
                consecutiveWins = 1;  // Reset the consecutiveWins counter to 1, as the current element is a win.
            } else {
                consecutiveWins++;  // If the current element is not a win, increment the consecutiveWins counter.
            }

            if (consecutiveWins == k) {  // Check if the consecutiveWins count reaches the specified threshold (k).
                break;  // If k consecutive wins are achieved, exit the loop.
            }
        }

        return currentWinner;  // Return the currentWinner, which is the winner after k consecutive wins.
    }
}

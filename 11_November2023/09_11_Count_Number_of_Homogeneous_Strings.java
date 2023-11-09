// Link: https://leetcode.com/problems/count-number-of-homogenous-substrings/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public int countHomogenous(String s) {
    final int kMod = 1_000_000_007;
    int ans = 0; // Initialize the answer
    int count = 0; // Initialize the count of consecutive characters
    char currentChar = '@'; // Initialize the current character to a placeholder

    // Iterate through each character in the string
    for (final char c : s.toCharArray()) {
      count = c == currentChar ? count + 1 : 1; // Update count based on the current character
      currentChar = c; // Update the current character

      // Add the count to the answer and take modulo to avoid overflow
      ans += count;
      ans %= kMod;
    }

    return ans; // Return the final answer
  }
}

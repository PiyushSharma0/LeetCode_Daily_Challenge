// Link: https://leetcode.com/problems/bag-of-tokens/
// Difficulty: Medium
// Time Complexity: O(nlogn)
// Space Complexity: O(1)

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int maxScore = 0;
        int left = 0;
        int right = tokens.length - 1;

        Arrays.sort(tokens);

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
                maxScore = Math.max(maxScore, score);
            } else if (score >= 1) {
                power += tokens[right];
                score--;
                right--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}
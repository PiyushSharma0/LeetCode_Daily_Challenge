// Link: https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // Convert the answerKey string to a character array
        char[] answers = answerKey.toCharArray();

        int maxConsecutive = 0; // Maximum number of consecutive answers achieved so far
        int maxCount = 0; // Maximum count of a single answer in the current sequence
        int[] answerCount = new int[128]; // Array to count the occurrences of each answer

        for (int i = 0; i < answers.length; i++) {
            char currentAnswer = answers[i];

            // Increment the count of the current answer and update the maximum count
            maxCount = Math.max(maxCount, ++answerCount[currentAnswer]);

            // Check if the number of changes made (result - maxCount) is less than k
            if (maxConsecutive - maxCount < k) {
                maxConsecutive++; // Increment the maximum number of consecutive answers achieved
            } else {
                char answerToRemove = answers[i - maxConsecutive];
                answerCount[answerToRemove]--; // Decrement the count of the answer that is no longer part of the sequence
            }
        }

        return maxConsecutive; // Return the maximum number of consecutive answers achievable
    }
}

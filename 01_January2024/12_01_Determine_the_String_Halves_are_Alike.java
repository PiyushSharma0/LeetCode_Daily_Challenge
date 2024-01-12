// Link: https://leetcode.com/problems/determine-if-string-halves-are-alike/
// Difficulty: Easy
// Time complexity: O(n) where n is the length of the string
// Space complexity: O(1)

class Solution {
    public boolean halvesAreAlike(String s) {
        int midIndex = s.length() / 2;

        String leftHalf = s.substring(0, midIndex);
        String rightHalf = s.substring(midIndex);

        int leftCount = countVowels(leftHalf);
        int rightCount = countVowels(rightHalf);

        return leftCount == rightCount;
    }

    private int countVowels(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}
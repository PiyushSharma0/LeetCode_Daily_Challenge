// Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/
// Difficulty: Easy
// Time complexity: O(log n)
// Space complexity: O(1)

public char nextGreatestLetter(char[] letters, char target) {
    int n = letters.length;
    int left = 0;
    int right = n - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (letters[mid] <= target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    // in the array, the next greatest character is the first character.
    // If the target is greater than or equal to the last character
    if (left == n) {
        return letters[0];
    } else {
        return letters[left];
    }
}

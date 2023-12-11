// Link: https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
// Difficulty: Easy
// Time complexity: O(n) where n is the length of the array
// Space complexity: O(1)

class Solution {
    public int findSpecialInteger(int[] arr) {
        int threshold = arr.length / 4;

        for (int i = 0; i < arr.length - threshold; i++) {
            if (arr[i] == arr[i + threshold]) {
                return arr[i];
            }
        }

        // This line should not be reached if there is always an element that occurs more than 25% of the time.
        return -1;
    }
}

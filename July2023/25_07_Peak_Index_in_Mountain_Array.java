// Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
// Difficulty: Medium but I think it's easy
// Time complexity: O(log n) because we are using binary search
// Space complexity: O(1) because we are not using any extra space

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the mid element is smaller than the next element, we are on the ascending side.
            // Move left to search for the peak on the ascending side.
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } 
            // If the mid element is greater than the next element, we are on the descending side.
            // Move right to search for the peak on the descending side.
            else {
                right = mid;
            }
        }

        // At the end of the loop, left and right will converge to the peak index.
        return left;
    }
}
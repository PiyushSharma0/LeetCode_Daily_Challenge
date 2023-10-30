// Link: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
// Difficulty: Easy
// Time complexity: O(nlogn)
// Space complexity: O(n)

import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        // Create an Integer array to store the input numbers for sorting
        Integer[] intArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = arr[i];
        }

        // Use Arrays.sort with a custom comparator
        Arrays.sort(intArr, (a, b) -> {
            // Count the number of 1's in the binary representation of 'a' and 'b'
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);

            if (bitCountA != bitCountB) {
                // If the number of 1's is different, sort by the number of 1's in ascending order
                return bitCountA - bitCountB;
            } else {
                // If the number of 1's is the same, sort the numbers themselves in ascending order
                return a - b;
            }
        });

        // Copy the sorted values back to the original 'arr' array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = intArr[i];
        }

        return arr;
    }
}

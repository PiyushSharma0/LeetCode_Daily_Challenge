// Link: https://leetcode.com/problems/non-overlapping-intervals/
// Difficulty: Medium
// Time complexity: O(nlogn) where n is the number of intervals
// Space complexity: O(1)

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort the intervals based on their end times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int nonOverlapEnd = intervals[0][1]; // Initialize with the end time of the first interval
        int count = 1; // Count of non-overlapping intervals

        for (int i = 1; i < intervals.length; i++) {
            // Check if the current interval overlaps with the last non-overlapping interval
            if (intervals[i][0] >= nonOverlapEnd) {
                // If it doesn't overlap, update the last non-overlapping interval's end time
                nonOverlapEnd = intervals[i][1];
                count++;
            }
            // If it overlaps, skip this interval and move on to the next one
        }

        // The minimum number of intervals to remove is equal to the total number of intervals minus the count of non-overlapping intervals
        return intervals.length - count;
    }
}

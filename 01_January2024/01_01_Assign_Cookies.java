// Link: https://leetcode.com/problems/assign-cookies/
// Difficulty: Easy
// Time complexity: O(nlogn)
// Space complexity: O(1)

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] childGreedFactors, int[] cookieSizes) {
        // Sort arrays in ascending order
        Arrays.sort(childGreedFactors);
        Arrays.sort(cookieSizes);

        int childIndex = childGreedFactors.length - 1;
        int cookieIndex = cookieSizes.length - 1;
        int contentChildrenCount = 0;

        // Iterate through the arrays from the end
        while (childIndex >= 0 && cookieIndex >= 0) {
            // Check if the current cookie size is sufficient for the child's greed factor
            if (childGreedFactors[childIndex] <= cookieSizes[cookieIndex]) {
                cookieIndex--;
                contentChildrenCount++;
            }
            childIndex--;
        }

        return contentChildrenCount;
    }
}

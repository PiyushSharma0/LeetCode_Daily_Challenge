// Link: https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
// Difficulty: Easy
// Time complexity: O(n) [n = number of elements in the array]
// Space complexity: O(1)

class Solution {
    public int maxProductDifference(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        // Iterate through the array to find the two largest and two smallest elements
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        // Calculate the product difference using the found values
        int productDiff = (max1 * max2) - (min1 * min2);

        return productDiff;
    }
}

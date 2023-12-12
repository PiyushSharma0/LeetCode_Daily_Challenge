// Link: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
// Difficulty: Easy
// Time complexity: O(n) where n is the length of the array
// Space complexity: O(1)

class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;  // Largest element
        int max2 = Integer.MIN_VALUE;  // Second largest element

        // Iterate through the array to find the two largest elements
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        // Calculate the maximum product
        return (max1 - 1) * (max2 - 1);
    }
}

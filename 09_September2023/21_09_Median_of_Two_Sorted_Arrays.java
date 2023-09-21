// Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
// Difficulty: Hard
// Time complexity: O(log(min(m,n)))
// Space complexity: O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is the smaller array
        }
        
        int m = nums1.length;
        int n = nums2.length;
        
        int low = 0;
        int high = m;
        
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                } else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        
        // If we reach here, it means the arrays are not sorted, which is an error.
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
